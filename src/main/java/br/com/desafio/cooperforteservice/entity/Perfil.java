package br.com.desafio.cooperforteservice.entity;

import br.com.desafio.cooperforteservice.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "perfil")
public class Perfil implements GrantedAuthority {
    @Id
    private Long id;

    @Column(name = "papel")
    private String nome;

    @Override
    public String getAuthority() {
        return nome;
    }

//    @OneToMany(mappedBy = "perfil")
//    @JsonIgnore
//    private List<Usuario> usuarios;
}
