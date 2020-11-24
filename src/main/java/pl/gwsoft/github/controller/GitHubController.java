package pl.gwsoft.github.controller;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gwsoft.github.dto.GitRepositoryDto;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@RestController
public class GitHubController {

    private GitHub gitHub;

    @Autowired
    public GitHubController(GitHub gitHub) {
        this.gitHub = gitHub;
    }

    @RequestMapping("/repositories/{owner}/{repositoryName}")
    public GitRepositoryDto getDetails(@PathVariable String owner, @PathVariable String repositoryName) throws IOException {
        GHRepository gitRepo = gitHub.getRepository(owner + "/" + repositoryName);
        GitRepositoryDto repo = new GitRepositoryDto();
        repo.setDescription(gitRepo.getDescription());
        repo.setFullName(gitRepo.getFullName());
        repo.setCloneUrl(gitRepo.getHttpTransportUrl());
        repo.setCreatedAt(getLocalDateFromDate(gitRepo.getCreatedAt()));
        repo.setStars(gitRepo.getStargazersCount());
        return repo;
    }

    private LocalDate getLocalDateFromDate(Date date){
        if(date == null) return null;
        return LocalDate.from(Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()));
    }
}
