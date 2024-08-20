package org.acme.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.acme.dto.CompanyDto;
import org.acme.entity.Company;
import org.acme.service.CompanyService;

import java.util.List;
import java.util.Optional;

@Path("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @POST
    @Transactional
    public Response saveUser(@Valid CompanyDto request){
        Optional<CompanyDto> saveCompany = companyService.save(request);

        if (saveCompany.isPresent()){
            return Response.ok(saveCompany.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    public Response findAll(){
        Optional<List<Company>> companies = companyService.findAll();

        if (companies.isPresent()){
            return Response.ok(companies.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
