package me.srsrks.mp.quickstart;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/pokemon")
public class NanduResource {
    private final String message;
    @Inject
    public NanduResource(@ConfigProperty(name = "app.pokemon") String message) {
        this.message = message;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Message getAllPokemon(){
        String endpoint = message+"pokemon";
        PokemonApiService service = new PokemonApiService();
        String response = service.fetchPokemon(endpoint);
        Message msg = new Message();
        msg.setPokeData(response);
        return msg;
    }

    @Path("/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Message getPokemon(@PathParam("name") String pokemon){
        String endpoint = message+"pokemon/"+pokemon;
        PokemonApiService service = new PokemonApiService();
        String response = service.fetchPokemon(endpoint);
        Message msg = new Message();
        msg.setPokeData(response);
        return msg;
    }

}
