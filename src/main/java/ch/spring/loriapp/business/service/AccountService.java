package ch.spring.loriapp.business.service;

import java.util.Collections;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.spring.loriapp.business.entity.Account;
import ch.spring.loriapp.business.repository.AccountRepository;
import ch.spring.loriapp.business.riot.common.Region;
import ch.spring.loriapp.business.riot.service.SummonerService;
import ch.spring.loriapp.config.CustomUserDetails;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AccountService implements UserDetailsService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	SummonerService summonserService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostConstruct
	protected void initialize() {
		save(new Account("admin@admin.ch", "admin", "Loori", "admin", Region.EUW, "ROLE_USER"));
	}

	@Transactional
	public Account save(Account account) {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		accountRepository.save(account);
		return account;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findOneByUsername(username);
		if (account == null) {
			throw new UsernameNotFoundException("user not found");
		}
		return createUser(account);
	}

	public void signin(Account account) {
		SecurityContextHolder.getContext().setAuthentication(authenticate(account));
	}

	private Authentication authenticate(Account account) {
		return new UsernamePasswordAuthenticationToken(createUser(account), null, Collections.singleton(createAuthority(account)));
	}

	private CustomUserDetails createUser(Account account) {
		return new CustomUserDetails(account.getUsername(), account.getSummonerName(), account.getPassword(), account.getRegion(),
				Collections.singleton(createAuthority(account)));
	}

	private GrantedAuthority createAuthority(Account account) {
		return new SimpleGrantedAuthority(account.getRole());
	}

}
