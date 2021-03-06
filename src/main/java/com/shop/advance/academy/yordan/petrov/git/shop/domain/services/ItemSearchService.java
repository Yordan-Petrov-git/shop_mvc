package com.shop.advance.academy.yordan.petrov.git.shop.domain.services;

import com.shop.advance.academy.yordan.petrov.git.shop.domain.dto.ItemServiceViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Interface service for .
 *
 * @author Yordan Petrov
 * @version 1.0.0.0
 * @since Jul 8, 2020.
 */
@Service
public interface ItemSearchService {

    /**
     * @param title
     * @return
     */
    ItemServiceViewModel getItemByTitle(String title);

    /**
     * @param title
     * @return
     */
    List<ItemServiceViewModel> getItemByTitleLike(String title);
}
