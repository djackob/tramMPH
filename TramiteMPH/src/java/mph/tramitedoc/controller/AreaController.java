package mph.tramitedoc.controller;

//@Erick Escalante Olano
import mph.tramitedoc.be.AreaBE;
import mph.tramitedoc.bl.AreaBL;
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
@RequestMapping("/AreaController")
@SessionAttributes({"oSession"})
public class AreaController {

    Gson gson = new GsonBuilder().serializeNulls().create();
    String json = "";

    @RequestMapping(value = "/insertarAreaBE.htm", method = RequestMethod.POST, headers = "content-type=application/json")
    public @ResponseBody
    String insertarAreaBE(@RequestBody Map<String, Object> param) {

        AreaBL oAreaBL = new AreaBL();
        AreaBE oAreaBE = gson.fromJson(gson.toJson(param.get("poAreaBE")), AreaBE.class);
        json = gson.toJson(oAreaBL.insertarAreaBE(oAreaBE));
        return json;

    }

    @RequestMapping(value = "/actualizarAreaBE.htm", method = RequestMethod.POST)
    public @ResponseBody
    String actualizarAreaBE(@RequestBody Map<String, Object> param) {

        AreaBL oAreaBL = new AreaBL();
        AreaBE oAreaBE = gson.fromJson(gson.toJson(param.get("poAreaBE")), AreaBE.class);
        json = gson.toJson(oAreaBL.actualizarAreaBE(oAreaBE));
        return json;

    }

    @RequestMapping(value = "/eliminarAreaBE.htm", method = RequestMethod.POST)
    public @ResponseBody
    String eliminarAreaBE(@RequestBody Map<String, Object> param) {

        AreaBL oAreaBL = new AreaBL();
        AreaBE oAreaBE = gson.fromJson(gson.toJson(param.get("poAreaBE")), AreaBE.class);
        json = gson.toJson(oAreaBL.eliminarAreaBE(oAreaBE));
        return json;

    }

    @RequestMapping(value = "/listarRegistrosAreaBE.htm", method = RequestMethod.POST)
    public @ResponseBody
    String listarRegistrosAreaBE(@RequestBody Map<String, Object> param) throws UnsupportedEncodingException {
        AreaBL oAreaBL = new AreaBL();
        AreaBE oAreaBE = gson.fromJson(gson.toJson(param.get("poAreaBE")), AreaBE.class);

        json = gson.toJson(oAreaBL.listarRegistrosAreaBE(oAreaBE));
        String s2 = new String(json.getBytes("UTF-8"), "ISO-8859-1");
        return s2;
    }

    @RequestMapping(value = "/listObjectAreaBE.htm", method = RequestMethod.POST)
    public @ResponseBody
    String listObjectAreaBE(@RequestBody Map<String, Object> param) throws UnsupportedEncodingException {
        AreaBL oAreaBL = new AreaBL();
        AreaBE oAreaBE = gson.fromJson(gson.toJson(param.get("poAreaBE")), AreaBE.class);

        json = gson.toJson(oAreaBL.listObjectAreaBE(oAreaBE));
        String s2 = new String(json.getBytes("UTF-8"), "ISO-8859-1");
        return s2;
    }

}
