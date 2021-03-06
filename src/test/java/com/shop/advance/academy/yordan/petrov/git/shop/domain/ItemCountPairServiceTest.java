package com.shop.advance.academy.yordan.petrov.git.shop.domain;

import com.shop.advance.academy.yordan.petrov.git.shop.data.dao.ItemCountPairDao;
import com.shop.advance.academy.yordan.petrov.git.shop.data.models.ItemCountPair;
import com.shop.advance.academy.yordan.petrov.git.shop.domain.dto.ItemCountPairServiceViewModel;
import com.shop.advance.academy.yordan.petrov.git.shop.domain.services.ItemCountPairService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Class test  for .
 *
 * @author Yordan Petrov
 * @version 1.0.0.0
 * @since Jul 8, 2020.
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ItemCountPairServiceTest {

    @MockBean
    ItemCountPairDao itemCountPairDao;

    @Autowired
    ItemCountPairService itemCountPairService;

    @Autowired
    ModelMapper modelMapper;

    @BeforeEach
    private void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testItemCountPairServiceReturnsAllItemCountPairs() {
        List<ItemCountPair> itemCountPairs = new ArrayList<>();
        itemCountPairs.add(new ItemCountPair());
        itemCountPairs.add(new ItemCountPair());
        itemCountPairs.add(new ItemCountPair());

        Mockito.when(itemCountPairDao.findAll()).thenReturn(itemCountPairs);
        List<ItemCountPairServiceViewModel> itemCountPairsFetchedFromRepo = itemCountPairService.getAllItemCountPairs();

        assertEquals(3, itemCountPairsFetchedFromRepo.size());
    }


    @Test
    public void testItemCountPairServiceGetItemCountPairById() {
        ItemCountPair itemCountPair = new ItemCountPair();
        itemCountPair.setId(15L);

        Mockito.when(itemCountPairDao.findById(15L))
                .thenReturn(java.util.Optional.of(itemCountPair));
        ItemCountPairServiceViewModel itemCountPairServiceViewModel = this.modelMapper.map(itemCountPair, ItemCountPairServiceViewModel.class);

        assertEquals(itemCountPairServiceViewModel, itemCountPairService.getItemCountPairById(15L));
    }

    //TODO ADD TEST IF CREATES

    //TODO ADD TEST IF REMOVES

    //TODO ADD TEST IF UPDATES
}
