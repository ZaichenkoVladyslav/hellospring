package zay.edu.hellospring.service.cafedra.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zay.edu.hellospring.dao.cafedra.impls.DaoCafedraImpl;
import zay.edu.hellospring.model.Cafedra;
import zay.edu.hellospring.repository.CafedraRepository;
import zay.edu.hellospring.service.cafedra.interfaces.ICafedraService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service

public class CafedraServiceImpl implements ICafedraService {

    /*@Autowired
    DaoCafedraImpl daoCafedra;*/

    @Autowired
    CafedraRepository cafedraRepository;

    @Override
    public Cafedra create(Cafedra cafedra) {
        cafedra.setCreatedAt(LocalDateTime.now());
        cafedra.setUpdatedAt(LocalDateTime.now());
        return cafedraRepository.save(cafedra);
    }

    @Override
    public Cafedra get(String id) {
        return cafedraRepository.findById(id).orElse(null);
    }

    @Override
    public Cafedra delete(String id) {
        Cafedra cafedra = this.get(id);
        cafedraRepository.deleteById(cafedra.getId());
        return cafedra;
    }

    @Override
    public Cafedra update(Cafedra cafedra) {
        cafedra.setUpdatedAt(LocalDateTime.now());
        return cafedraRepository.save(cafedra);
    }

    @Override
    public List<Cafedra> getAll() {
        return cafedraRepository.findAll();
    }
}
