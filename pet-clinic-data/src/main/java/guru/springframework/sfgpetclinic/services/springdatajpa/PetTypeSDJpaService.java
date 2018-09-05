package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @java.lang.Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petType -> {
            petTypes.add(petType);
        });

        return petTypes;
    }

    @java.lang.Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @java.lang.Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @java.lang.Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @java.lang.Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
