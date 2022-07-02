package mindera.midswap.SwapRecipes.zgreetings;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequestMapping("/response")
@RestController
public class HomeController {

//    @PostMapping("/postbody")
//    public String postBody(@RequestBody String fullName) {
//        return "Hello " + fullName;
//    }
//
//
//    @PostMapping(
//            value = "/postbody",
//            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public ResponseEntity<Person> postBody(@RequestBody Person person) {
//        Person persistedPerson = personService.save(person);
//        return ResponseEntity
//                .created(URI
//                        .create(String.format("/persons/%s", person.getFirstName())))
//                .body(persistedPerson);
//    }

}
