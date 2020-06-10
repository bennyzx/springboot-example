package cn.eggnetech.eggnetechspringdataweb.controller;

import cn.eggnetech.eggnetechspringdataweb.pojo.Password;
import cn.eggnetech.eggnetechspringdataweb.pojo.User;
import cn.eggnetech.eggnetechspringdataweb.pojo.Username;
import cn.eggnetech.eggnetechspringdataweb.service.UserManagement;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

import static org.springframework.validation.ValidationUtils.rejectIfEmptyOrWhitespace;

/**
 * @name:
 * @description: Created by Benny Zhou on 2020/3/20
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserManagement userManagement;

    /**
     * Equips the model with a {@link Page} of {@link User}s. Spring Data automatically populates the {@link Pageable} from
     * request data according to the setup of {@link PageableHandlerMethodArgumentResolver}. Note how the defaults can be
     * tweaked by using {@link PageableDefault}.
     *
     * @param pageable will never be {@literal null}.
     * @return
     */
    @ModelAttribute("users")
    public Page<User> users(@PageableDefault(size = 5) Pageable pageable) {
        return userManagement.findAll(pageable);
    }

    /**
     * Registers a new {@link User} for the data provided by the given {@link UserForm}.
     * Note, how an interface is used to bind request parameters.
     *
     * @param userForm      the request data bound to the {@link UserForm} instance.
     * @param bindingResult the result of the binding operation.
     * @param model         the Spring MVC {@link Model}.
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Object register(UserForm userForm, BindingResult bindingResult, Model model) {
        userForm.validate(bindingResult, userManagement);

        if (bindingResult.hasErrors()) {
            return "users";
        }

        userManagement.register(new Username(userForm.getUsername()), Password.raw(userForm.getPassword()));

        RedirectView redirectView = new RedirectView("redirect:/users");
        redirectView.setPropagateQueryParams(true);
        return redirectView;
    }

    /**
     * Populates the {@link Model} with the {@link UserForm} automatically created by Spring Data web components. It will
     * create a {@link Map}-backed proxy for the interface.
     *
     * @param model    will never be {@literal null}.
     * @param userForm will never be {@literal null}.
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String listUsers(Model model, UserForm userForm) {
        model.addAttribute("userForm", userForm);
        return "users";
    }

    /**
     * An interface to represent the form to be used
     */
    interface UserForm {
        String getUsername();

        String getPassword();

        String getRepeatedPassword();

        /**
         * Validates the {@link UserForm}.
         *
         * @param errors
         * @param userManagement
         */
        default void validate(BindingResult errors, UserManagement userManagement) {
            rejectIfEmptyOrWhitespace(errors, "username", "user.username.empty");
            rejectIfEmptyOrWhitespace(errors, "password", "user.password.empty");
            rejectIfEmptyOrWhitespace(errors, "repeatedPassword", "user.repeatedPassword.empty");

            if (!getPassword().equals(getRepeatedPassword())) {
                errors.rejectValue("repeatedPassword", "user.password.no-match");
            }

            try {
                userManagement.findByUsername(new Username(getUsername())).ifPresent(user -> errors.rejectValue("username", "user.username.exists"));
            } catch (IllegalArgumentException o_O) {
                errors.rejectValue("username", "user.username.invalidFormat");
            }
        }
    }
}
