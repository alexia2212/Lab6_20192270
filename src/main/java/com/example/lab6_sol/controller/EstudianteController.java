package com.example.lab6_sol.controller;

import com.example.lab6_sol.entity.Usuario;
import com.example.lab6_sol.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/lista")
    public String listaUsuarios(Model model){

        List<Usuario> estudiantes = usuarioRepository.findByRolid(5);
        model.addAttribute("estudiantes", estudiantes);
        return "lista_usuarios";
    }
    @GetMapping("nuevo")
    public String newEstudiante(Model model) {

        return "crearForm";
    }

    @PostMapping("save")
    public String saveEmployee(@ModelAttribute("usuario") @Valid Usuario usuario, BindingResult bindingResult, RedirectAttributes attr) {
        if(bindingResult.hasErrors()){
            attr.addFlashAttribute("msg", "Estudiante presenta errores");
            return "redirect:/crearForm";

        }else{
            attr.addFlashAttribute("msg", "Estudiante actualizado existosamente");
            usuarioRepository.save(usuario);
            return "redirect:/lista";
        }
    }

    @GetMapping("/edit")
    public String editarEmpleado(Model model, @RequestParam("id") int id) {
        Optional<Usuario> optional = usuarioRepository.findById(id);

        if (optional.isPresent()) {
            model.addAttribute("employee", optional.get());
            return "editForm";
        } else {
            return "redirect:/lista";
        }

    }
}
