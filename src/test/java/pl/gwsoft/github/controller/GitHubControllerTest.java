package pl.gwsoft.github.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pl.gwsoft.github.GithubApplication;
import pl.gwsoft.github.dto.GitRepositoryDto;

import java.io.IOException;
import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {GithubApplication.class})
public class GitHubControllerTest {

    public static final String HTTP_TEST_URL = "https://github.com/grzegorzwodo/test.git";
    public static final String DESCRIPTION = null;
    public static final String FULL_NAME = "grzegorzwodo/test";
    public static final int STARS = 0;
    public static final LocalDate createdAt = LocalDate.of(2018,01,27);;

    @Autowired
    private GitHubController controller;

    @Test
    public void githubConnectionTest() throws IOException {
        GitRepositoryDto repoDto = controller.getDetails("grzegorzwodo", "test");

        assertEquals(FULL_NAME, repoDto.getFullName());
        assertEquals(DESCRIPTION, repoDto.getDescription());
        assertEquals(HTTP_TEST_URL, repoDto.getCloneUrl());
        assertEquals(STARS, repoDto.getStars());
        assertEquals(createdAt, repoDto.getCreatedAt());
    }

}

