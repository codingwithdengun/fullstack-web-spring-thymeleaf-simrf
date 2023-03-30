package com.afterlife.javafullstackweb.services;

import com.afterlife.javafullstackweb.models.Assets;

import java.util.List;
import java.util.Optional;

public interface AssetsService {

    // tambah data
    Assets saveAssets(Assets assets);
    // get all data
    List<Assets> getAllDataAssets();
    // get data by id
    Optional<Assets> getDataAssetsById(Integer id);
    // delete data by id
    void deleteDataAssetById(Integer id);
}
