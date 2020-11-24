package pl.gwsoft.github.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class GitRepositoryDto {
    String fullName;
    String description;
    String cloneUrl;
    int stars;
    LocalDate createdAt;
}
