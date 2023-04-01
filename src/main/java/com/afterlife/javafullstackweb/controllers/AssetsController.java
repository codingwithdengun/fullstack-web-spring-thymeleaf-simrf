package com.afterlife.javafullstackweb.controllers;

import com.afterlife.javafullstackweb.models.Assets;
import com.afterlife.javafullstackweb.usecases.AssetUsecase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/assets")
@Slf4j
public class AssetsController {

    @Autowired
    private AssetUsecase assetUsecase;

    // METHOD  UNTUK GET INDEX DATA ASSETS DARI DATABASE
    @GetMapping(value = "/index")
    public String getIndex(ModelMap map, RedirectAttributes redirectAttributes, BindingResult result) {
        // berikan kondisi saat error
        if(result.hasErrors()){
            log.error("Ada Kesalahan, Silahkan Check Kembali, berikut detailnya : " + result);
        }
        map.addAttribute("assets", assetUsecase.getAllDataAssets());
        redirectAttributes.addFlashAttribute("alertSuccess", "Get Data Berhasil");
        return "/pages/assets/index";
    }

    // METHOD UNTUK GET FORM -> UNTUK MENGARAHKAN KE FORM TAMBAH DATA
    @GetMapping(value = "/form")
    public String getForm(ModelMap map, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            log.error("Ada Kesalahan, Silahkan Check Kembali, berikut detailnya : " + result);
        }
        map.addAttribute("getFormassets", assetUsecase.getAllDataAssets());
        redirectAttributes.addFlashAttribute("alertSuccess", "Get Form Berhasil");
        return "/pages/assets/form";
    }
    // METHOD UNTUK TAMBAH DATA
    @PostMapping(value = "/submit")
    public String saveData(@ModelAttribute(value = "assets") Assets assets, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            log.error("Ada Kesalahan, Silahkan Check Kembali, berikut detailnya : " + bindingResult);
            return "redirect:/assets/form";
        }
        assetUsecase.saveAssets(assets);
        redirectAttributes.addFlashAttribute("alertSuccess", "Save Data Berhasil");
        return "redirect:/assets/index";
    }

    // METHOD UNTUK GET FORM EDIT -> MENGARAHKAN KE FORM EDIT
    @GetMapping(value = "/form/{id}")
    public String getFormEdit(ModelMap map, @PathVariable(value = "id") Integer id, BindingResult result,
                              RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            log.error("Ada Kesalahan, Silahkan Check Kembali, berikut detailnya : " + result);
            return "redirect:/assets/index";
        }
        map.addAttribute("getEditAssets", assetUsecase.getDataAssetsById(id));
        redirectAttributes.addFlashAttribute("alertSuccess", "Get Edit Data Berhasil");
        return "redirect:/assets/edit";
    }

    // METHOD UNTUK EDIT DATANYA (UPDATE DATA)
    @PostMapping(value = "/update/{id}")
    public String updateData(ModelMap map, @ModelAttribute(value = "assets") Assets assets, BindingResult result,
                             RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            log.error("Ada Kesalahan, Silahkan Check Kembali, berikut detailnya : " + result);
        }
        map.addAttribute("updateAssets", assets);
        assetUsecase.saveAssets(assets);
        redirectAttributes.addFlashAttribute("alertSuccess", "Update Data Berhasil");
        return "redirect:/assets/index";
    }

    // METHOD UNTUK REMOVE DATANYA
    @GetMapping(value = "/delete/{id}")
    public String removeData(@PathVariable(value = "id") Integer id, BindingResult result,
                             RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            log.error("Ada Kesalahan, Silahkan Check Kembali, berikut detailnya : " + result);
        }
        assetUsecase.deleteDataAssetById(id);
        redirectAttributes.addFlashAttribute("alertSuccess", "Delete Data Berhasil");
        return "redirect:/assets/index";
    }

}
