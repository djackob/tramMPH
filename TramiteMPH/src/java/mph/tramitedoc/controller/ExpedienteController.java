package mph.tramitedoc.controller;

//@Erick Escalante Olano
import mph.tramitedoc.be.ExpedienteBE;
import mph.tramitedoc.bl.ExpedienteBL;
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
@RequestMapping("/ExpedienteController")
@SessionAttributes({"oSession"})
public class ExpedienteController {

    Gson gson = new GsonBuilder().serializeNulls().create();
    String json = "";

    @RequestMapping(value = "/insertarExpedienteBE.htm", method = RequestMethod.POST, headers = "content-type=application/json")
    public @ResponseBody
    String insertarExpedienteBE(@RequestBody Map<String, Object> param) {

        ExpedienteBL oExpedienteBL = new ExpedienteBL();
        ExpedienteBE oExpedienteBE = gson.fromJson(gson.toJson(param.get("poExpedienteBE")), ExpedienteBE.class);
        json = gson.toJson(oExpedienteBL.insertarExpedienteBE(oExpedienteBE));
        return json;

    }

    @RequestMapping(value = "/actualizarExpedienteBE.htm", method = RequestMethod.POST)
    public @ResponseBody
    String actualizarExpedienteBE(@RequestBody Map<String, Object> param) {

        ExpedienteBL oExpedienteBL = new ExpedienteBL();
        ExpedienteBE oExpedienteBE = gson.fromJson(gson.toJson(param.get("poExpedienteBE")), ExpedienteBE.class);
        json = gson.toJson(oExpedienteBL.actualizarExpedienteBE(oExpedienteBE));
        return json;

    }

    @RequestMapping(value = "/eliminarExpedienteBE.htm", method = RequestMethod.POST)
    public @ResponseBody
    String eliminarExpedienteBE(@RequestBody Map<String, Object> param) {

        ExpedienteBL oExpedienteBL = new ExpedienteBL();
        ExpedienteBE oExpedienteBE = gson.fromJson(gson.toJson(param.get("poExpedienteBE")), ExpedienteBE.class);
        json = gson.toJson(oExpedienteBL.eliminarExpedienteBE(oExpedienteBE));
        return json;

    }

    @RequestMapping(value = "/listarRegistrosExpedienteBE.htm", method = RequestMethod.POST)
    public @ResponseBody
    String listarRegistrosExpedienteBE(@RequestBody Map<String, Object> param) throws UnsupportedEncodingException {
        ExpedienteBL oExpedienteBL = new ExpedienteBL();
        ExpedienteBE oExpedienteBE = gson.fromJson(gson.toJson(param.get("poExpedienteBE")), ExpedienteBE.class);

        json = gson.toJson(oExpedienteBL.listarRegistrosExpedienteBE(oExpedienteBE));
        String s2 = new String(json.getBytes("UTF-8"), "ISO-8859-1");
        return s2;
    }

    @RequestMapping(value = "/listObjectExpedienteBE.htm", method = RequestMethod.POST)
    public @ResponseBody
    String listObjectExpedienteBE(@RequestBody Map<String, Object> param) throws UnsupportedEncodingException {
        ExpedienteBL oExpedienteBL = new ExpedienteBL();
        ExpedienteBE oExpedienteBE = gson.fromJson(gson.toJson(param.get("poExpedienteBE")), ExpedienteBE.class);

        json = gson.toJson(oExpedienteBL.listObjectExpedienteBE(oExpedienteBE));
        String s2 = new String(json.getBytes("UTF-8"), "ISO-8859-1");
        return s2;
    }

}
