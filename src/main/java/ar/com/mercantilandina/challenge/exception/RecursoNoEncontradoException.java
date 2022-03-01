package ar.com.mercantilandina.challenge.exception;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecursoNoEncontradoException extends RuntimeException {
    
    private String name;
    private String label;
    private UUID value;

    public RecursoNoEncontradoException(String name, String label, UUID value){
        super(String.format("%s no encontrado con %s %s", name, label, value));
        System.out.println("ESTO LE MANDO");
        System.out.println(String.format("%s no encontrado con %s: '%s'", name, label, value));
        System.out.println("ESTO ME DEVUELVE");
        System.out.println(super.getMessage());
        setName(name);
        setLabel(label);
        setValue(value);
    }

}
