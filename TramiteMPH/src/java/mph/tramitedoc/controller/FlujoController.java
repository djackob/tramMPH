package mph.tramitedoc.controller;


//@Erick Escalante Olano


import mph.tramitedoc.be.FlujoBE;
import mph.tramitedoc.bl.FlujoBL;
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
@RequestMapping("/FlujoController")
@SessionAttributes({"oSession"})
public class FlujoController {

    Gson gson = new GsonBuilder().serializeNulls().create();
    String json = "";

    @RequestMapping(value = "/insertarFlujoBE.htm", method = RequestMethod.POST, headers = "content-type=application/json")
    public @ResponseBody
    String insertarFlujoBE(@RequestBody Map<String, Object> param) {

        FlujoBL oFlujoBL = new FlujoBL();
        FlujoBE oFlujoBE = gson.fromJson(gson.toJson(param.get("poFlujoBE")), FlujoBE.class);
        json = gson.toJson(oFlujoBL.insertarFlujoBE(oFlujoBE));
        return json;

    }

    @RequestMapping(value = "/actualizarFlujoBE.htm", method = RequestMethod.POST)
    public @ResponseBody
    String actualizarFlujoBE(@RequestBody Map<String, Object> param) {

        FlujoBL oFlujoBL = new FlujoBL();
        FlujoBE oFlujoBE = gson.fromJson(gson.toJson(param.get("poFlujoBE")), FlujoBE.class);
        json = gson.toJson(oFlujoBL.actualizarFlujoBE(oFlujoBE));
        return json;

    }

    @RequestMapping(value = "/eliminarFlujoBE.htm", method = RequestMethod.POST)
    public @ResponseBody
    String eliminarFlujoBE(@RequestBody Map<String, Object> param) {

        FlujoBL oFlujoBL = new FlujoBL();
        FlujoBE oFlujoBE = gson.fromJson(gson.toJson(param.get("poFlujoBE")), FlujoBE.class);
        json = gson.toJson(oFlujoBL.eliminarFlujoBE(oFlujoBE));
        return json;

    }

    @RequestMapping(value = "/listarRegistrosFlujoBE.htm", method = RequestMethod.POST)
    public @ResponseBody
    String listarRegistrosFlujoBE(@RequestBody Map<String, Object> param) throws UnsupportedEncodingException {
        FlujoBL oFlujoBL = new FlujoBL();
        FlujoBE oFlujoBE = gson.fromJson(gson.toJson(param.get("poFlujoBE")), FlujoBE.class);

        json = gson.toJson(oFlujoBL.listarRegistrosFlujoBE(oFlujoBE));
        String s2 = new String(json.getBytes("UTF-8"), "ISO-8859-1");
        return s2;
    }

    @RequestMapping(value = "/listObjectFlujoBE.htm", method = RequestMethod.POST)
    public @ResponseBody
    String listObjectFlujoBE(@RequestBody Map<String, Object> param) throws UnsupportedEncodingException {
        FlujoBL oFlujoBL = new FlujoBL();
        FlujoBE oFlujoBE = gson.fromJson(gson.toJson(param.get("poFlujoBE")), FlujoBE.class);

        json = gson.toJson(oFlujoBL.listObjectFlujoBE(oFlujoBE));
        String s2 = new String(json.getBytes("UTF-8"), "ISO-8859-1");
        return s2;
    }

}
