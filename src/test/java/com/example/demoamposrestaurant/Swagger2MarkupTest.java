package com.example.demoamposrestaurant;

import io.github.swagger2markup.Swagger2MarkupConverter;
import org.asciidoctor.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.File;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles(profiles = "document")
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Swagger2MarkupTest {

    @Autowired
    private MockMvc mockMvc;

    @Value("${output.dir.html}")
    private String htmlOutputDir;

    @Test
    public void convert() throws Exception {
        MvcResult result = mockMvc
                .perform(get("/v2/api-docs?group=staff-order-api"))
                .andExpect(status().isOk())
                .andReturn();

        String swaggerJson = result.getResponse().getContentAsString();
        String adoc = Swagger2MarkupConverter.from(swaggerJson).build().toString();

        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
        OptionsBuilder optionsBuilder = OptionsBuilder.options()
                .mkDirs(true)
                .toFile(new File( htmlOutputDir + "/index.html"))
                .backend("html5")
                .docType("book")
                .headerFooter(true)
                .safe(SafeMode.UNSAFE)
                .attributes(AttributesBuilder.attributes()
                        .copyCss(true)
                        .linkCss(false)
                        .sectNumLevels(3)
                        .setAnchors(true)
                        .hardbreaks(true)
                        .tableOfContents(Placement.LEFT));
        asciidoctor.convert(adoc, optionsBuilder);
    }
}
