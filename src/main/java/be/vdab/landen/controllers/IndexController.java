package be.vdab.landen.controllers;

import be.vdab.landen.services.LandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
@RequestMapping("/")
class IndexController {
    private final LandService landService;

    IndexController(LandService landService) throws IOException {
        this.landService = landService;
        var homeDirectory = Path.of(System.getProperty("user.home")); //consructor icinde home/user directory si tanimladik
        var bestand = homeDirectory.resolve("organisatie.txt");       //home/user icine organisatie adinda bir text dosyasi tanimladik
        if (!Files.exists(bestand)) {                                       //organisatie.txt halihazirda yoksa
            Files.writeString(bestand, "VDAB");                         //olusturup icine "VDAB" yazdik
            System.out.println(bestand + " gemaakt");                       //"home/hdogan/organisatie.txt gemaakt" ve "home/cnb/organisatie.txt gemaakt" yazdirdik
        }                                                                   //spring-boot:build-image yapinca butun bu komutlari image icine yerlestirdi
    }                                                                       //imageden bir container yapip ona bir volume'i mount ettigimizde organisatie.txt otomatik olarak volume icine yazildi
                                                                            //bundan sonra container her calistirildiginda organisatie.txt yi volumedan yukleyecek
    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("index", "aantalLanden", landService.findAantal());
    }
}
