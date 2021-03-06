package com.shop.advance.academy.yordan.petrov.git.shop.web.rest.controllers;


import com.shop.advance.academy.yordan.petrov.git.shop.domain.dto.MediaServiceModel;
import com.shop.advance.academy.yordan.petrov.git.shop.domain.dto.MediaServiceViewModel;
import com.shop.advance.academy.yordan.petrov.git.shop.domain.services.MediaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Class controller for the media.
 *
 * @author Yordan Petrov
 * @version 1.0.0.0
 * @since Jul 8, 2020.
 */
@RestController
@RequestMapping("api/media")
@Slf4j
public class MediaController {

    private final MediaService mediaService;

    /**
     * Constructor
     */
    @Autowired
    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }


    /**
     * @param mediaServiceModel
     * @return
     */
    @PostMapping()
    @PreAuthorize("isAuthenticated() and hasAuthority('ROLE_USER')")
    public ResponseEntity<MediaServiceViewModel> createMedia(@RequestBody MediaServiceModel mediaServiceModel) {
        MediaServiceViewModel mediaServiceViewModel = mediaService.createMedia(mediaServiceModel);
        URI location = MvcUriComponentsBuilder.fromMethodName(MediaController.class, "createMedia", MediaServiceViewModel.class)
                .pathSegment("{id}").buildAndExpand(mediaServiceViewModel.getId()).toUri();
        log.info("Media  created : {} {}", mediaServiceViewModel, location);
        return ResponseEntity.created(location).body(mediaServiceViewModel);
    }

    /**
     * Method for
     *
     * @param mediaServiceModel
     * @return
     */
    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated() and hasAuthority('ROLE_USER')")
    public ResponseEntity<MediaServiceViewModel> updateMedia(@RequestBody MediaServiceModel mediaServiceModel) {
        MediaServiceViewModel mediaServiceViewModel = mediaService.updateMedia(mediaServiceModel);
        log.info("Media  UPDATED : {}", mediaServiceViewModel);
        return ResponseEntity.status(HttpStatus.OK).body(mediaServiceViewModel);
    }


    /**
     * Method for
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated() and hasAuthority('ROLE_USER')")
    public ResponseEntity<MediaServiceViewModel> getMedia(@PathVariable("id") final Long id) {
        MediaServiceViewModel mediaServiceViewModel = mediaService.getMediaById(id);
        log.info("Media  FOUND : {}", mediaServiceViewModel);
        return ResponseEntity.status(HttpStatus.FOUND).body(mediaServiceViewModel);
    }

    /**
     * Method for
     *
     * @return
     */
    @GetMapping()
    @PreAuthorize("isAuthenticated() and hasAuthority('ROLE_USER')")
    public ResponseEntity<List<MediaServiceViewModel>> getMedias() {
        List<MediaServiceViewModel> mediaServiceViewModels = mediaService.getAllMedias();
        log.info("Medias Found: {} ", mediaServiceViewModels);
        return ResponseEntity.status(HttpStatus.FOUND).body(mediaServiceViewModels);
    }

    /**
     * Method for
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated() and hasAuthority('ROLE_USER')")
    public ResponseEntity<MediaServiceViewModel> deleteMedia(@PathVariable("id") Long id) {
        MediaServiceViewModel mediaServiceViewModel = mediaService.deleteMediaById(id);
        log.info("Media deleted : {}", mediaServiceViewModel);
        return ResponseEntity.status(HttpStatus.OK).body(mediaServiceViewModel);
    }
}
