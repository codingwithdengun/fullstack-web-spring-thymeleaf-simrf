package com.afterlife.javafullstackweb.usecases;

import com.afterlife.javafullstackweb.models.Assets;
import com.afterlife.javafullstackweb.repositories.AssetsRepository;
import com.afterlife.javafullstackweb.services.AssetsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class AssetUsecase implements AssetsService {

    @Autowired
    private AssetsRepository asset;

    public Assets saveAssets(Assets assets) {
        return asset.save(assets);
    }

    public List<Assets> getAllDataAssets() {
        return asset.findAll();
    }

    public Optional<Assets> getDataAssetsById(Integer id) {
        return asset.findById(id);
    }

    public void deleteDataAssetById(Integer id) {
        asset.deleteById(id);
    }
}
