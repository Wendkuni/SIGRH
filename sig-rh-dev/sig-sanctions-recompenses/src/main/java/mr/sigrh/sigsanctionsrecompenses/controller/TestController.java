package mr.sigrh.sigsanctionsrecompenses.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :  <A HREF="mailto:dieudonneouedra@gmail.com">Dieudonné OUEDRAOGO (Wendkouny)</A>
 * @version : 1.0
 * Copyright (c) 2024 SONGRE-TECH, All rights reserved.
 * @since : 2024/07/07 à 12:10
 */

@RestController
@RequestMapping("greeting")
@Tag(name = "Sanctions Recompenses", description = "Gestion des sanctions recompenses")
public class TestController {

    @GetMapping
    public String sayHello() {
        return "Hello world, ready to spring ?";
    }
}
