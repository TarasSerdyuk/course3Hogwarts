package ru.hogwarts.school.controllers;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @GetMapping
    public Collection<Faculty> getAllFaculties() {
        return facultyService.getAllFaculties();
    }
    @PostMapping
    public Faculty addFaculty(@RequestBody Faculty faculty) {
        return facultyService.addFaculty(faculty);
    }
    @GetMapping("/{id}")
    public Faculty getFacultyById(@PathVariable Long id) {
        return facultyService.getFacultyById(id);
    }
    @PutMapping("/{id}")
    public Faculty updateFaculty(@PathVariable Long id, @RequestBody Faculty faculty) {
        return facultyService.updateFaculty(id, faculty);
    }

    @DeleteMapping("/{id}")
    public void deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
    }
    @GetMapping(params = {"color"})
    public Collection<Faculty> getFacultiesByColor(@RequestParam String color) {
        return facultyService.getFacultiesByColor(color);
    }
}