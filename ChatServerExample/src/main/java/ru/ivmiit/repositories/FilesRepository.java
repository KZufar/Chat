package ru.ivmiit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ivmiit.models.File;

public interface FilesRepository extends JpaRepository<File, Long> {

    File findFirstByStorageName(String fileName);
}
