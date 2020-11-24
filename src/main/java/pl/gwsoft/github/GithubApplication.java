package pl.gwsoft.github;

import org.kohsuke.github.GitHub;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@SpringBootApplication
public class GithubApplication {

	@Bean
	public GitHub createGitHub() throws IOException {
		return GitHub.connectAnonymously();
	}

	public static void main(String[] args) {
		SpringApplication.run(GithubApplication.class, args);
	}
}
