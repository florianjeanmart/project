package be.flo.project.converter;

import be.flo.project.controller.technical.security.role.RoleEnum;
import be.flo.project.dto.LangDTO;
import be.flo.project.model.entities.Role;
import org.dozer.CustomConverter;
import org.dozer.DozerConverter;
import play.Logger;
import play.i18n.Lang;

/**
 * Created by florian on 16/04/15.
 */
public class RoleConverter extends DozerConverter<Role, RoleEnum> implements CustomConverter {

    public RoleConverter() {
        super(Role.class, RoleEnum.class);
    }


    @Override
    public RoleEnum convertTo(Role role, RoleEnum roleEnum) {
        return role.getRoleEnum();
    }

    @Override
    public Role convertFrom(RoleEnum roleEnum, Role role) {
        return new Role(roleEnum);
    }
}
