package com.lhzn.soft.project.services.impl;

import com.google.common.base.CaseFormat;
import com.lhzn.soft.project.domain.*;
import com.lhzn.soft.project.services.BusinessHandleService;
import com.lhzn.soft.project.services.Xml82Service;
import org.dom4j.Document;
import org.dom4j.Element;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Xml82ServiceImpl implements Xml82Service {
    @Resource
    private BusinessHandleService handleService;

    @Override
    public Map<String, Object> xmlResolve (Document document) throws Exception {
        GatherdataLog gl = new GatherdataLog ();
        Map<String, Object> rMap = new HashMap<> (9);
        for (Element element : (List<Element>) document.getRootElement ().elements ()) {
            if (element.elements ().size () > 0) {
                if (element.getName ().trim ().equals ("IC_INFO")) {
                    IcInfo ic = new IcInfo ();
                    for (Element childElement : (List<Element>) element.elements ()) {
                        genObj (ic, childElement);
                    }
                    rMap.put ("ic", ic);
                }
                if (element.getName ().trim ().equals ("FORM_INFO")) {
                    FormInfo fi = new FormInfo ();
                    for (Element childElement : (List<Element>) element.elements ()) {
                        genObj (fi, childElement);
                    }
                    rMap.put ("fi", fi);
                }
                if (element.getName ().trim ().equals ("VE_RFID")) {
                    VeRfid veRfid = new VeRfid ();
                    for (Element childElement : (List<Element>) element.elements ()) {
                        genObj (veRfid, childElement);
                    }
                    rMap.put ("veRfid", veRfid);
                }
                if (element.getName ().trim ().equals ("DR_RFID")) {
                    DrRfid dr = new DrRfid ();
                    for (Element childElement : (List<Element>) element.elements ()) {
                        genObj (dr, childElement);
                    }
                    rMap.put ("dr", dr);
                }
                if (element.getName ().trim ().equals ("PHOTO")) {
                    Photo photo = new Photo ();
                    for (Element childElement : (List<Element>) element.elements ()) {
                        genObj (photo, childElement);
                    }
                    rMap.put ("photo", photo);
                }
                if (element.getName ().trim ().equals ("EXTEND")) {
                    Extend extend = new Extend ();
                    for (Element childElement : (List<Element>) element.elements ()) {
                        genObj (extend, childElement);
                    }
                    rMap.put ("extend", extend);
                }
                if (element.getName ().trim ().equals ("CONTA_RECOGNITION")) {
                    ContaRecognition cr = new ContaRecognition ();
                    for (Element childElement : (List<Element>) element.elements ()) {
                        genObj (cr, childElement);
                    }
                    rMap.put ("cr", cr);

                }
                if (element.getName ().trim ().equals ("VE_LICENSE_RECOGNITION")) {
                    VeLicenseRecognition vr = new VeLicenseRecognition ();
                    for (Element childElement : (List<Element>) element.elements ()) {
                        genObj (vr, childElement);
                    }
                    rMap.put ("vr", vr);
                }
            } else {
                genObj (gl, element);
            }
        }
        rMap.put ("gl", gl);
        return rMap;
    }

    @Override
    public void xmlUpdate (Map<String, Object> map, String xml) {

        handleService.XmlUpdate(map, xml);
    }

    public <D> void genObj (D d, Element element) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String guava = CaseFormat.UPPER_UNDERSCORE.to (CaseFormat.UPPER_CAMEL, element.getName ());
        Method method = d.getClass ().getMethod ("set" + guava, String.class);
        method.invoke (d, element.getTextTrim ());

    }


}