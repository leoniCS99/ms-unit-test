package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.acme.dto.CompanyDto;
import org.acme.entity.Company;
import org.acme.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public Optional<CompanyDto> save(CompanyDto companyDto) {
        try {

           Company company = Company.builder()
                           .name(companyDto.name())
                           .address(companyDto.address())
                           .registry(companyDto.registry())
                           .phone(companyDto.phone())
                   .build();


            companyRepository.persist(company);
            int listSize = companyRepository.listAll().size();
            Company saveCompany = companyRepository.listAll().get(listSize - 1);

            return Optional.of(new
                    CompanyDto(saveCompany.getId(),
                    saveCompany.getName(),
                    saveCompany.getAddress(),
                    saveCompany.getRegistry(),
                    saveCompany.getPhone()));

        } catch (Exception exception) {
            return Optional.empty();
        }
    }

    public Optional<List<Company>> findAll() {
        return Optional.of(companyRepository.findAll().list());
    }
}
