package mph.tramitedoc.controller;


//@Erick Escalante Olano


import mph.tramitedoc.be.UsuarioBE;
import mph.tramitedoc.bl.UsuarioBL;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping("/UsuarioController")
@SessionAttributes({"oSession"})
public class UsuarioController {

    Gson gson = new GsonBuilder().serializeNulls().create();
    String json = "";

    @RequestMapping(value = "/insertarUsuarioBE.htm", method = RequestMethod.POST, headers = "content-type=application/json")
    public @ResponseBody
    String insertarUsuarioBE(@RequestBody Map<String, Object> param) {

        UsuarioBL oUsuarioBL = new UsuarioBL();
        UsuarioBE oUsuarioBE = gson.fromJson(gson.toJson(param.get("poUsuarioBE")), UsuarioBE.class);
        json = gson.toJson(oUsuarioBL.insertarUsuarioBE(oUsuarioBE));
        return json;

    }

    @RequestMapping(value = "/actualizarUsuarioBE.htm", method = RequestMethod.POST)
    public @ResponseBody
    String actualizarUsuarioBE(@RequestBody Map<String, Object> param) {

        UsuarioBL oUsuarioBL = new UsuarioBL();
        UsuarioBE oUsuarioBE = gson.fromJson(gson.toJson(param.get("poUsuarioBE")), UsuarioBE.class);
        json = gson.toJson(oUsuarioBL.actualizarUsuarioBE(oUsuarioBE));
        return json;

    }

    @RequestMapping(value = "/eliminarUsuarioBE.htm", method = RequestMethod.POST)
    public @ResponseBody
    String eliminarUsuarioBE(@RequestBody Map<String, Object> param) {

        UsuarioBL oUsuarioBL = new UsuarioBL();
        UsuarioBE oUsuarioBE = gson.fromJson(gson.toJson(param.get("poUsuarioBE")), UsuarioBE.class);
        json = gson.toJson(oUsuarioBL.eliminarUsuarioBE(oUsuarioBE));
        return json;

    }

    @RequestMapping(value = "/listarRegistrosUsuarioBE.htm", method = RequestMethod.POST)
    public @ResponseBody
    String listarRegistrosUsuarioBE(@RequestBody Map<String, Object> param) throws UnsupportedEncodingException {
        UsuarioBL oUsuarioBL = new UsuarioBL();
        UsuarioBE oUsuarioBE = gson.fromJson(gson.toJson(param.get("poUsuarioBE")), UsuarioBE.class);

        json = gson.toJson(oUsuarioBL.listarRegistrosUsuarioBE(oUsuarioBE));
        String s2 = new String(json.getBytes("UTF-8"), "ISO-8859-1");
        return s2;
    }

    @RequestMapping(value = "/listObjectUsuarioBE.htm", method = RequestMethod.POST)
    public @ResponseBody
    String listObjectUsuarioBE(@RequestBody Map<String, Object> param) throws UnsupportedEncodingException {
        UsuarioBL oUsuarioBL = new UsuarioBL();
        UsuarioBE oUsuarioBE = gson.fromJson(gson.toJson(param.get("poUsuarioBE")), UsuarioBE.class);

        json = gson.toJson(oUsuarioBL.listObjectUsuarioBE(oUsuarioBE));
        String s2 = new String(json.getBytes("UTF-8"), "ISO-8859-1");
        return s2;
    }

}
