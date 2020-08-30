package net.sourceforge.javaqemu.model;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.HashMap;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FileModel {

    private String machineName;
    private String machineType;
    private String machineAccel1;
    private String machineAccel2;
    private String machineAccel3;
    private String machineKernel_irpchip;
    private String machineKvm_shadow_mem;
    private String machineDump_guest_core;
    private String machineMem_merge;
    private String cpuModel;
    private String cpuidFlags;
    private String cdrom;
    private String floppyDiskA;
    private String floppyDiskB;
    private String bootOrder1;
    private String bootOrder2;
    private String bootOrder3;
    private String bootOnce1;
    private String bootOnce2;
    private String bootOnce3;
    private String bootMenu;
    private String bootSplash;
    private String bootSplashTime;
    private String bootRebootTimeout;
    private String bootStrict;
    private String keyboardLayoutLanguage;
    private String firstHardDiskOption;
    private String secondHardDiskOption;
    private String thirdHardDiskOption;
    private String fourthHardDiskOption;
    private String ramSize;
    private String displayType;
    private String nographicOption;
    private String vgaType;
    private String fullscreenOption;
    private String win2khackOption;
    private String noacpiOption;
    private String soundHardwareOption;
    private String smpCpusNumber;
    private String smpCoresNumber;
    private String smpThreadsNumber;
    private String smpSocketsNumber;
    private String smpCpusMaxNumber;
    private String firstNumaNodeMem;
    private String firstNumaNodeCpus;
    private String secondNumaNodeMem;
    private String secondNumaNodeCpus;
    private String thirdNumaNodeMem;
    private String thirdNumaNodeCpus;
    private String fourthNumaNodeMem;
    private String fourthNumaNodeCpus;
    private String fifthNumaNodeMem;
    private String fifthNumaNodeCpus;
    private String sixthNumaNodeMem;
    private String sixthNumaNodeCpus;
    private String seventhNumaNodeMem;
    private String seventhNumaNodeCpus;
    private String eighthNumaNodeMem;
    private String eighthNumaNodeCpus;
    private String ninthNumaNodeMem;
    private String ninthNumaNodeCpus;
    private String tenthNumaNodeMem;
    private String tenthNumaNodeCpus;
    private String noFrameOption;
    private String memPathOption;
    private String memPreallocOption;
    private String firstNetworkNICOption;
    private String firstNetworkExtraOption;
    private String firstNetworkNetdevOption;
    private String secondNetworkNICOption;
    private String secondNetworkExtraOption;
    private String secondNetworkNetdevOption;
    private String thirdNetworkNICOption;
    private String thirdNetworkExtraOption;
    private String thirdNetworkNetdevOption;
    private String fourthNetworkNICOption;
    private String fourthNetworkExtraOption;
    private String fourthNetworkNetdevOption;
    private String fifthNetworkNICOption;
    private String fifthNetworkExtraOption;
    private String fifthNetworkNetdevOption;
    private String sixthNetworkNICOption;
    private String sixthNetworkExtraOption;
    private String sixthNetworkNetdevOption;
    private String seventhNetworkNICOption;
    private String seventhNetworkExtraOption;
    private String seventhNetworkNetdevOption;
    private String eighthNetworkNICOption;
    private String eighthNetworkExtraOption;
    private String eighthNetworkNetdevOption;
    private String ninthNetworkNICOption;
    private String ninthNetworkExtraOption;
    private String ninthNetworkNetdevOption;
    private String tenthNetworkNICOption;
    private String tenthNetworkExtraOption;
    private String tenthNetworkNetdevOption;
    private String rtcOption;
    private String nameOption;
    private String snapshotOption;
    private String noFdBootchkOption;
    private String noHpetOption;
    private String mtdblockOption;
    private String sdOption;
    private String pflashOption;
    private String monitorOption;
    private String qmpOption;
    private String usbDriverOption;
    private String usbMouseOption;
    private String usbTabletOption;
    private String usbWacomTabletOption;
    private String usbKeyboardOption;
    private String usbBrailleOption;
    private String usbDiskOption;
    private String usbSerialOption;
    private String usbNetOption;
    private String kernelBootOption;
    private String customOptions;

    private String defaultVMPath;
    private String execute_before_start_qemu;
    private String qemu_executable_path;
    private String execute_after_stop_qemu;
    private String qemu_img_executable_path;
    private String bios_vga_bios_keymaps_path;

    private Map<String, String> data = new HashMap<>();
    private Map<String, String> dataConfig = new HashMap<>();

    private void populateCustomData(Element doc, Map<String, String> customData) {
        customData.clear();
        NodeList nodeList = doc.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                if (node.hasChildNodes()) {
                    customData.put(node.getNodeName(), node.getFirstChild().getNodeValue());
                }
            }
        }
    }
    
    private void populateData(Element doc) {
    	this.populateCustomData(doc, data);
    }

    private void populateDataConfig(Element doc) {
    	this.populateCustomData(doc, dataConfig);
    }
    
    private void setField(String field, String value) {
    	Field f1;
    	try {
			f1 = this.getClass().getDeclaredField(field);
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
			return;
		}
		
    	try {
			f1.set(this, value);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
			return;
		}
    }
    
    private String getField(String field) {
    	Field f1;
    	try {
    		f1 = this.getClass().getDeclaredField(field);
    	} catch (NoSuchFieldException | SecurityException e) {
			return "";
		}
    	
    	try {
    		return (String) f1.get(this);
    	} catch (IllegalAccessException | IllegalArgumentException | SecurityException e) {
    		e.printStackTrace();
			return "";
		}
    }
    
    private static String[] attribs = {"bootMenu", "bootOnce1", 
    		"bootOnce2", "bootOnce3", "bootOrder1", "bootOrder2", 
    		"bootOrder3", "bootRebootTimeout", "bootSplash", 
    		"bootSplashTime", "bootStrict", "cdrom", "cpuModel", 
    		"cpuidFlags", "customOptions", "displayType", 
    		"eighthNetworkExtraOption", "eighthNetworkNICOption", 
    		"eighthNetworkNetdevOption", "eighthNumaNodeCpus", 
    		"eighthNumaNodeMem", "fifthNetworkExtraOption", 
    		"fifthNetworkNICOption", "fifthNetworkNetdevOption", 
    		"fifthNumaNodeCpus", "fifthNumaNodeMem", "firstHardDiskOption", 
    		"firstNetworkExtraOption", "firstNetworkNICOption", 
    		"firstNetworkNetdevOption", "firstNumaNodeCpus", 
    		"firstNumaNodeMem", "floppyDiskA", "floppyDiskB", 
    		"fourthHardDiskOption", "fourthNetworkExtraOption", 
    		"fourthNetworkNICOption", "fourthNetworkNetdevOption", 
    		"fourthNumaNodeCpus", "fourthNumaNodeMem", "fullscreenOption", 
    		"kernelBootOption", "keyboardLayoutLanguage", 
    		"machineAccel1", "machineAccel2", "machineAccel3", 
    		"machineDump_guest_core", "machineKernel_irpchip", 
    		"machineKvm_shadow_mem", "machineMem_merge", "machineName", 
    		"machineType", "memPathOption", "memPreallocOption", 
    		"monitorOption", "mtdblockOption", "nameOption", 
    		"ninthNetworkExtraOption", "ninthNetworkNICOption", 
    		"ninthNetworkNetdevOption", "ninthNumaNodeCpus", 
    		"ninthNumaNodeMem", "noFdBootchkOption", "noFrameOption", 
    		"noHpetOption", "noacpiOption", "nographicOption", 
    		"pflashOption", "qmpOption", "ramSize", "rtcOption", 
    		"sdOption", "secondHardDiskOption", "secondNetworkExtraOption", 
    		"secondNetworkNICOption", "secondNetworkNetdevOption", 
    		"secondNumaNodeCpus", "secondNumaNodeMem", 
    		"seventhNetworkExtraOption", "seventhNetworkNICOption", 
    		"seventhNetworkNetdevOption", "seventhNumaNodeCpus", 
    		"seventhNumaNodeMem", "sixthNetworkExtraOption", 
    		"sixthNetworkNICOption", "sixthNetworkNetdevOption", 
    		"sixthNumaNodeCpus", "sixthNumaNodeMem", "smpCoresNumber", 
    		"smpCpusMaxNumber", "smpCpusNumber", "smpSocketsNumber", 
    		"smpThreadsNumber", "snapshotOption", "soundHardwareOption", 
    		"tenthNetworkExtraOption", "tenthNetworkNICOption", 
    		"tenthNetworkNetdevOption", "tenthNumaNodeCpus", 
    		"tenthNumaNodeMem", "thirdHardDiskOption", 
    		"thirdNetworkExtraOption", "thirdNetworkNICOption", 
    		"thirdNetworkNetdevOption", "thirdNumaNodeCpus", 
    		"thirdNumaNodeMem", "usbBrailleOption", 
    		"usbDiskOption", "usbDriverOption", "usbKeyboardOption", 
    		"usbMouseOption", "usbNetOption", "usbSerialOption", 
    		"usbTabletOption", "usbWacomTabletOption", "vgaType", 
    		"win2khackOption"};
    
    public boolean readXML(String xml) {
        Document dom;
        // Make an instance of the DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // use the factory to take an instance of the document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // parse using the builder to get the DOM mapping of the
            // XML file
            dom = db.parse(xml);

            Element doc = dom.getDocumentElement();

            this.populateData(doc);

            for (String attr : attribs) {
            	setField(attr, getTextValue(doc, attr));            	
            }

            // Custom reading fields subroutine...!
            if (cdrom != null) {
            	cdrom = cdrom.replaceAll("\"", "");
            }

            if (firstHardDiskOption == null) {
                firstHardDiskOption = getTextValue(doc, "diskPath"); // Deprecated definition.
            }

            if (firstHardDiskOption == null) {
                firstHardDiskOption = getTextValue(doc, "diskImagePath"); // Another deprecated definition.
            }

            if (firstHardDiskOption != null) {
            	firstHardDiskOption = firstHardDiskOption.replaceAll("\"", "");
            }

            // Deprecated definition: "secondDiskImagePath"...
            if (secondHardDiskOption == null) {
                secondHardDiskOption = getTextValue(doc, "secondDiskImagePath"); // Standard definition.
            }

            if (secondHardDiskOption != null) {
            	secondHardDiskOption = secondHardDiskOption.replaceAll("\"", "");
            }

            // Deprecated definition: "thirdDiskImagePath"...
            if (thirdHardDiskOption == null) {
                thirdHardDiskOption = getTextValue(doc, "thirdDiskImagePath"); // Standard definition.
            }

            if (thirdHardDiskOption != null) {
            	thirdHardDiskOption = thirdHardDiskOption.replaceAll("\"", "");
            }

            // Deprecated definition: "fourthDiskImagePath"...
            if (fourthHardDiskOption == null) {
                fourthHardDiskOption = getTextValue(doc, "fourthDiskImagePath"); // Standard definition.
            }

            if (fourthHardDiskOption != null) {
            	fourthHardDiskOption = fourthHardDiskOption.replaceAll("\"", "");
            }

            if (memPathOption != null) {
            	memPathOption = memPathOption.replaceAll("\"", "");
            }

            System.out.println("Read custom options data...");
            
            System.out.println("Saving XML file");
            saveToXML(xml);
            System.out.println("Saved XML file");

            return true;
        } catch (ParserConfigurationException pce) {
            System.out.println(pce.getMessage());
        } catch (SAXException se) {
            System.out.println(se.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        return false;
    }

    public boolean readConfigurationFromXML(String xml) {
        Document dom;
        // Make an instance of the DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // use the factory to take an instance of the document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // parse using the builder to get the DOM mapping of the
            // XML file
            dom = db.parse(xml);

            Element doc = dom.getDocumentElement();

            this.populateDataConfig(doc);
            
            defaultVMPath = getConfigTextValue(doc, "defaultVMPath");
            execute_before_start_qemu = getConfigTextValue(doc, "execute_before_start_qemu");
            qemu_executable_path = getConfigTextValue(doc, "qemu_executable_path");
            execute_after_stop_qemu = getConfigTextValue(doc, "execute_after_stop_qemu");
            qemu_img_executable_path = getConfigTextValue(doc, "qemu_img_executable_path");
            bios_vga_bios_keymaps_path = getConfigTextValue(doc, "bios_vga_bios_keymaps_path");
            return true;

        } catch (ParserConfigurationException pce) {
            System.out.println(pce.getMessage());
        } catch (SAXException se) {
            System.out.println(se.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        return false;
    }

    public void saveToXML(String xml) {
        Document dom;
        Element e = null;

        // instance of a DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // use factory to get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // create instance of DOM
            dom = db.newDocument();

            dom.setXmlStandalone(true);

            // create the root element
            Element rootEle = dom.createElement("JavaQemuMachine");

            // create data elements and place them under root
            for (String attr : attribs) {
            	String value = this.getField(attr);
            	
            	if (value != null) {
            		e = dom.createElement(attr);
            		e.appendChild(dom.createTextNode(value));
            		rootEle.appendChild(e);
            	}
            }

            dom.appendChild(rootEle);

            try {
                Transformer tr = TransformerFactory.newInstance()
                        .newTransformer();

                tr.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
                tr.setOutputProperty(OutputKeys.VERSION, "1.0");
                tr.setOutputProperty(OutputKeys.INDENT, "yes");
                tr.setOutputProperty(OutputKeys.METHOD, "xml");
                tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                tr.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "JavaQemuMachine");
                tr.setOutputProperty(
                        "{http://xml.apache.org/xslt}indent-amount", "4");

                tr.transform(new DOMSource(dom),
                        new StreamResult(new File(xml)));

            } catch (TransformerException te) {
                System.out.println(te.getMessage());
            }
        } catch (ParserConfigurationException pce) {
            System.out
                    .println("UsersXML: Error trying to instantiate DocumentBuilder "
                            + pce);
        }
    }

    public void saveConfigurationToXML(String xml) {
        Document dom;
        Element e = null;

        // instance of a DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // use factory to get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // create instance of DOM
            dom = db.newDocument();

            dom.setXmlStandalone(true);

            // create the root element
            Element rootEle = dom.createElement("JavaQemuConfiguration");

            // create data elements and place them under root
            if (defaultVMPath != null) {
                e = dom.createElement("defaultVMPath");
                e.appendChild(dom.createTextNode(defaultVMPath));
                rootEle.appendChild(e);
            }

            if (execute_before_start_qemu != null) {
                //e = dom.createElement("diskPath"); // deprecated
                e = dom.createElement("execute_before_start_qemu");
                e.appendChild(dom.createTextNode(execute_before_start_qemu));
                rootEle.appendChild(e);
            }

            if (qemu_executable_path != null) {
                e = dom.createElement("qemu_executable_path");
                e.appendChild(dom.createTextNode(qemu_executable_path));
                rootEle.appendChild(e);
            }

            if (execute_after_stop_qemu != null) {
                e = dom.createElement("execute_after_stop_qemu");
                e.appendChild(dom.createTextNode(execute_after_stop_qemu));
                rootEle.appendChild(e);
            }

            if (qemu_img_executable_path != null) {
                e = dom.createElement("qemu_img_executable_path");
                e.appendChild(dom.createTextNode(qemu_img_executable_path));
                rootEle.appendChild(e);
            }

            if (bios_vga_bios_keymaps_path != null) {
                e = dom.createElement("bios_vga_bios_keymaps_path");
                e.appendChild(dom.createTextNode(bios_vga_bios_keymaps_path));
                rootEle.appendChild(e);
            }

            dom.appendChild(rootEle);

            try {
                Transformer tr = TransformerFactory.newInstance()
                        .newTransformer();

                tr.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
                tr.setOutputProperty(OutputKeys.VERSION, "1.0");
                tr.setOutputProperty(OutputKeys.INDENT, "yes");
                tr.setOutputProperty(OutputKeys.METHOD, "xml");
                tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                tr.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "JavaQemuMachine");
                tr.setOutputProperty(
                        "{http://xml.apache.org/xslt}indent-amount", "4");

                tr.transform(new DOMSource(dom),
                        new StreamResult(new File(xml)));

            } catch (TransformerException te) {
                System.out.println(te.getMessage());
            }
        } catch (ParserConfigurationException pce) {
            System.out
                    .println("UsersXML: Error trying to instantiate DocumentBuilder "
                            + pce);
        }
    }

    private String getCustomTextValue(Element doc, String tag, Map<String, String> data) {
        if (data.containsKey(tag)) {
            return data.get(tag);
        }

        return null;
    }

    private String getTextValue(Element doc, String tag) {
    	return this.getCustomTextValue(doc, tag, data);
    }
    
    private String getConfigTextValue(Element doc, String tag) {
    	return this.getCustomTextValue(doc, tag, dataConfig);
    }
    
    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public void setFirstHardDiskOption(String firstHardDiskOption) {
        this.firstHardDiskOption = firstHardDiskOption;
    }

    public void setSecondHardDiskOption(String secondHardDiskOption) {
        this.secondHardDiskOption = secondHardDiskOption;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getMachineName() {
        return machineName;
    }

    public String getFirstHardDiskOption() {
        return firstHardDiskOption;
    }

    public String getSecondHardDiskOption() {
        return secondHardDiskOption;
    }

    public String getThirdHardDiskOption() {
        return thirdHardDiskOption;
    }

    public void setThirdHardDiskOption(String thirdHardDiskOption) {
        this.thirdHardDiskOption = thirdHardDiskOption;
    }

    public String getFourthHardDiskOption() {
        return fourthHardDiskOption;
    }

    public void setFourthHardDiskOption(String fourthHardDiskOption) {
        this.fourthHardDiskOption = fourthHardDiskOption;
    }

    public String checks_extension(String path) {
        String result = "";
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                result = "/";
                break;
            }
            if (path.charAt(i) == '\\') {
                result = "\\";
                break;
            }
        }
        return result;
    }

    public String getRamSize() {
        return JavaQemuUtils.removeDupChars(ramSize, ".");
    }

    public void setRamSize(String ramSize) {
        this.ramSize = ramSize;
    }

    public void setConfiguration(JTextField default_virtual_machines_path_choice,
            JTextArea execute_before_start_qemu_choices,
            JTextField qemu_executable_path_choice,
            JTextArea execute_after_stop_qemu_choices,
            JTextField qemu_img_executable_path_choice,
            JTextField bios_vga_bios_keymaps_path_choice) {
        this.defaultVMPath = default_virtual_machines_path_choice.getText();
        this.execute_before_start_qemu = execute_before_start_qemu_choices.getText();
        this.qemu_executable_path = qemu_executable_path_choice.getText();
        this.execute_after_stop_qemu = execute_after_stop_qemu_choices.getText();
        this.qemu_img_executable_path = qemu_img_executable_path_choice.getText();
        this.bios_vga_bios_keymaps_path = bios_vga_bios_keymaps_path_choice.getText();
    }

    public void getConfiguration(JTextField default_virtual_machines_path_choice,
            JTextArea execute_before_start_qemu_choices,
            JTextField qemu_executable_path_choice,
            JTextArea execute_after_stop_qemu_choices,
            JTextField qemu_img_executable_path_choice,
            JTextField bios_vga_bios_keymaps_path_choice) {
        default_virtual_machines_path_choice.setText(this.defaultVMPath);
        execute_before_start_qemu_choices.setText(this.execute_before_start_qemu);
        qemu_executable_path_choice.setText(this.qemu_executable_path);
        execute_after_stop_qemu_choices.setText(this.execute_after_stop_qemu);
        qemu_img_executable_path_choice.setText(this.qemu_img_executable_path);
        bios_vga_bios_keymaps_path_choice.setText(this.bios_vga_bios_keymaps_path);
    }

    public String getDefaultVMPath() {
        return defaultVMPath;
    }

    public void setDefaultVMPath(String defaultVMPath) {
        this.defaultVMPath = defaultVMPath;
    }

    public String getExecute_before_start_qemu() {
        return execute_before_start_qemu;
    }

    public void setExecute_before_start_qemu(String execute_before_start_qemu) {
        this.execute_before_start_qemu = execute_before_start_qemu;
    }

    public String getQemu_executable_path() {
        return qemu_executable_path;
    }

    public void setQemu_executable_path(String qemu_executable_path) {
        this.qemu_executable_path = qemu_executable_path;
    }

    public String getExecute_after_stop_qemu() {
        return execute_after_stop_qemu;
    }

    public void setExecute_after_stop_qemu(String execute_after_stop_qemu) {
        this.execute_after_stop_qemu = execute_after_stop_qemu;
    }

    public String getQemu_img_executable_path() {
        return qemu_img_executable_path;
    }

    public void setQemu_img_executable_path(String qemu_img_executable_path) {
        this.qemu_img_executable_path = qemu_img_executable_path;
    }

    public String getBios_vga_bios_keymaps_path() {
        return bios_vga_bios_keymaps_path;
    }

    public void setBios_vga_bios_keymaps_path(String bios_vga_bios_keymaps_path) {
        this.bios_vga_bios_keymaps_path = bios_vga_bios_keymaps_path;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public String getNographicOption() {
        return nographicOption;
    }

    public void setNographicOption(String nographicOption) {
        this.nographicOption = nographicOption;
    }

    public String getVgaType() {
        return vgaType;
    }

    public void setVgaType(String vgaType) {
        this.vgaType = vgaType;
    }

    public String getFullscreenOption() {
        return fullscreenOption;
    }

    public void setFullscreenOption(String fullscreenOption) {
        this.fullscreenOption = fullscreenOption;
    }

    public String getWin2khackOption() {
        return win2khackOption;
    }

    public void setWin2khackOption(String win2khackOption) {
        this.win2khackOption = win2khackOption;
    }

    public String getNoacpiOption() {
        return noacpiOption;
    }

    public void setNoacpiOption(String noacpiOption) {
        this.noacpiOption = noacpiOption;
    }

    public String getMachineAccel1() {
        return machineAccel1;
    }

    public void setMachineAccel1(String machineAccel1) {
        this.machineAccel1 = machineAccel1;
    }

    public String getMachineAccel2() {
        return machineAccel2;
    }

    public void setMachineAccel2(String machineAccel2) {
        this.machineAccel2 = machineAccel2;
    }

    public String getMachineAccel3() {
        return machineAccel3;
    }

    public void setMachineAccel3(String machineAccel3) {
        this.machineAccel3 = machineAccel3;
    }

    public String getMachineKernel_irpchip() {
        return machineKernel_irpchip;
    }

    public void setMachineKernel_irpchip(String machineKernel_irpchip) {
        this.machineKernel_irpchip = machineKernel_irpchip;
    }

    public String getMachineKvm_shadow_mem() {
        return machineKvm_shadow_mem;
    }

    public void setMachineKvm_shadow_mem(String machineKvm_shadow_mem) {
        this.machineKvm_shadow_mem = machineKvm_shadow_mem;
    }

    public String getMachineDump_guest_core() {
        return machineDump_guest_core;
    }

    public void setMachineDump_guest_core(String machineDump_guest_core) {
        this.machineDump_guest_core = machineDump_guest_core;
    }

    public String getMachineMem_merge() {
        return machineMem_merge;
    }

    public void setMachineMem_merge(String machineMem_merge) {
        this.machineMem_merge = machineMem_merge;
    }

    public String getCpuModel() {
        return cpuModel;
    }

    public void setCpuModel(String cpuModel) {
        this.cpuModel = cpuModel;
    }

    public String getCpuidFlags() {
        return cpuidFlags;
    }

    public void setCpuidFlags(String cpuidFlags) {
        this.cpuidFlags = cpuidFlags;
    }

    public String getCdrom() {
        return cdrom;
    }

    public void setCdrom(String cdrom) {
        this.cdrom = cdrom;
    }

    public String getFloppyDiskA() {
        return floppyDiskA;
    }

    public void setFloppyDiskA(String floppyDiskA) {
        this.floppyDiskA = floppyDiskA;
    }

    public String getFloppyDiskB() {
        return floppyDiskB;
    }

    public void setFloppyDiskB(String floppyDiskB) {
        this.floppyDiskB = floppyDiskB;
    }

    public String getBootOrder1() {
        return bootOrder1;
    }

    public void setBootOrder1(String bootOrder1) {
        this.bootOrder1 = bootOrder1;
    }

    public String getBootOrder2() {
        return bootOrder2;
    }

    public void setBootOrder2(String bootOrder2) {
        this.bootOrder2 = bootOrder2;
    }

    public String getBootOrder3() {
        return bootOrder3;
    }

    public void setBootOrder3(String bootOrder3) {
        this.bootOrder3 = bootOrder3;
    }

    public String getBootOnce1() {
        return bootOnce1;
    }

    public void setBootOnce1(String bootOnce1) {
        this.bootOnce1 = bootOnce1;
    }

    public String getBootOnce2() {
        return bootOnce2;
    }

    public void setBootOnce2(String bootOnce2) {
        this.bootOnce2 = bootOnce2;
    }

    public String getBootOnce3() {
        return bootOnce3;
    }

    public void setBootOnce3(String bootOnce3) {
        this.bootOnce3 = bootOnce3;
    }

    public String getBootMenu() {
        return bootMenu;
    }

    public void setBootMenu(String bootMenu) {
        this.bootMenu = bootMenu;
    }

    public String getBootSplash() {
        return bootSplash;
    }

    public void setBootSplash(String bootSplash) {
        this.bootSplash = bootSplash;
    }

    public String getBootSplashTime() {
        return bootSplashTime;
    }

    public void setBootSplashTime(String bootSplashTime) {
        this.bootSplashTime = bootSplashTime;
    }

    public String getBootRebootTimeout() {
        return bootRebootTimeout;
    }

    public void setBootRebootTimeout(String bootRebootTimeout) {
        this.bootRebootTimeout = bootRebootTimeout;
    }

    public String getBootStrict() {
        return bootStrict;
    }

    public void setBootStrict(String bootStrict) {
        this.bootStrict = bootStrict;
    }

    public String getKeyboardLayoutLanguage() {
        return keyboardLayoutLanguage;
    }

    public void setKeyboardLayoutLanguage(String keyboardLayoutLanguage) {
        this.keyboardLayoutLanguage = keyboardLayoutLanguage;
    }

    public String getSoundHardwareOption() {
        return soundHardwareOption;
    }

    public void setSoundHardwareOption(String soundHardwareOption) {
        this.soundHardwareOption = soundHardwareOption;
    }

    public String getSmpCpusNumber() {
        return smpCpusNumber;
    }

    public void setSmpCpusNumber(String smpCpusNumber) {
        this.smpCpusNumber = smpCpusNumber;
    }

    public String getSmpCoresNumber() {
        return smpCoresNumber;
    }

    public void setSmpCoresNumber(String smpCoresNumber) {
        this.smpCoresNumber = smpCoresNumber;
    }

    public String getSmpThreadsNumber() {
        return smpThreadsNumber;
    }

    public void setSmpThreadsNumber(String smpThreadsNumber) {
        this.smpThreadsNumber = smpThreadsNumber;
    }

    public String getSmpSocketsNumber() {
        return smpSocketsNumber;
    }

    public void setSmpSocketsNumber(String smpSocketsNumber) {
        this.smpSocketsNumber = smpSocketsNumber;
    }

    public String getSmpCpusMaxNumber() {
        return smpCpusMaxNumber;
    }

    public void setSmpCpusMaxNumber(String smpCpusMaxNumber) {
        this.smpCpusMaxNumber = smpCpusMaxNumber;
    }

    public String getFirstNumaNodeMem() {
        return firstNumaNodeMem;
    }

    public void setFirstNumaNodeMem(String firstNumaNodeMem) {
        this.firstNumaNodeMem = firstNumaNodeMem;
    }

    public String getFirstNumaNodeCpus() {
        return firstNumaNodeCpus;
    }

    public void setFirstNumaNodeCpus(String firstNumaNodeCpus) {
        this.firstNumaNodeCpus = firstNumaNodeCpus;
    }

    public String getSecondNumaNodeMem() {
        return secondNumaNodeMem;
    }

    public void setSecondNumaNodeMem(String secondNumaNodeMem) {
        this.secondNumaNodeMem = secondNumaNodeMem;
    }

    public String getSecondNumaNodeCpus() {
        return secondNumaNodeCpus;
    }

    public void setSecondNumaNodeCpus(String secondNumaNodeCpus) {
        this.secondNumaNodeCpus = secondNumaNodeCpus;
    }

    public String getThirdNumaNodeMem() {
        return thirdNumaNodeMem;
    }

    public void setThirdNumaNodeMem(String thirdNumaNodeMem) {
        this.thirdNumaNodeMem = thirdNumaNodeMem;
    }

    public String getThirdNumaNodeCpus() {
        return thirdNumaNodeCpus;
    }

    public void setThirdNumaNodeCpus(String thirdNumaNodeCpus) {
        this.thirdNumaNodeCpus = thirdNumaNodeCpus;
    }

    public String getFourthNumaNodeMem() {
        return fourthNumaNodeMem;
    }

    public void setFourthNumaNodeMem(String fourthNumaNodeMem) {
        this.fourthNumaNodeMem = fourthNumaNodeMem;
    }

    public String getFourthNumaNodeCpus() {
        return fourthNumaNodeCpus;
    }

    public void setFourthNumaNodeCpus(String fourthNumaNodeCpus) {
        this.fourthNumaNodeCpus = fourthNumaNodeCpus;
    }

    public String getFifthNumaNodeMem() {
        return fifthNumaNodeMem;
    }

    public void setFifthNumaNodeMem(String fifthNumaNodeMem) {
        this.fifthNumaNodeMem = fifthNumaNodeMem;
    }

    public String getFifthNumaNodeCpus() {
        return fifthNumaNodeCpus;
    }

    public void setFifthNumaNodeCpus(String fifthNumaNodeCpus) {
        this.fifthNumaNodeCpus = fifthNumaNodeCpus;
    }

    public String getSixthNumaNodeMem() {
        return sixthNumaNodeMem;
    }

    public void setSixthNumaNodeMem(String sixthNumaNodeMem) {
        this.sixthNumaNodeMem = sixthNumaNodeMem;
    }

    public String getSixthNumaNodeCpus() {
        return sixthNumaNodeCpus;
    }

    public void setSixthNumaNodeCpus(String sixthNumaNodeCpus) {
        this.sixthNumaNodeCpus = sixthNumaNodeCpus;
    }

    public String getSeventhNumaNodeMem() {
        return seventhNumaNodeMem;
    }

    public void setSeventhNumaNodeMem(String seventhNumaNodeMem) {
        this.seventhNumaNodeMem = seventhNumaNodeMem;
    }

    public String getSeventhNumaNodeCpus() {
        return seventhNumaNodeCpus;
    }

    public void setSeventhNumaNodeCpus(String seventhNumaNodeCpus) {
        this.seventhNumaNodeCpus = seventhNumaNodeCpus;
    }

    public String getEighthNumaNodeMem() {
        return eighthNumaNodeMem;
    }

    public void setEighthNumaNodeMem(String eighthNumaNodeMem) {
        this.eighthNumaNodeMem = eighthNumaNodeMem;
    }

    public String getEighthNumaNodeCpus() {
        return eighthNumaNodeCpus;
    }

    public void setEighthNumaNodeCpus(String eighthNumaNodeCpus) {
        this.eighthNumaNodeCpus = eighthNumaNodeCpus;
    }

    public String getNinthNumaNodeMem() {
        return ninthNumaNodeMem;
    }

    public void setNinthNumaNodeMem(String ninthNumaNodeMem) {
        this.ninthNumaNodeMem = ninthNumaNodeMem;
    }

    public String getNinthNumaNodeCpus() {
        return ninthNumaNodeCpus;
    }

    public void setNinthNumaNodeCpus(String ninthNumaNodeCpus) {
        this.ninthNumaNodeCpus = ninthNumaNodeCpus;
    }

    public String getTenthNumaNodeMem() {
        return tenthNumaNodeMem;
    }

    public void setTenthNumaNodeMem(String tenthNumaNodeMem) {
        this.tenthNumaNodeMem = tenthNumaNodeMem;
    }

    public String getTenthNumaNodeCpus() {
        return tenthNumaNodeCpus;
    }

    public void setTenthNumaNodeCpus(String tenthNumaNodeCpus) {
        this.tenthNumaNodeCpus = tenthNumaNodeCpus;
    }

    public String getNoFrameOption() {
        return noFrameOption;
    }

    public void setNoFrameOption(String noFrameOption) {
        this.noFrameOption = noFrameOption;
    }

    public String getMemPathOption() {
        return memPathOption;
    }

    public void setMemPathOption(String memPathOption) {
        this.memPathOption = memPathOption;
    }

    public String getMemPreallocOption() {
        return memPreallocOption;
    }

    public void setMemPreallocOption(String memPreallocOption) {
        this.memPreallocOption = memPreallocOption;
    }

    public String getFirstNetworkNICOption() {
        return firstNetworkNICOption;
    }

    public void setFirstNetworkNICOption(String firstNetworkNICOption) {
        this.firstNetworkNICOption = firstNetworkNICOption;
    }

    public String getFirstNetworkExtraOption() {
        return firstNetworkExtraOption;
    }

    public void setFirstNetworkExtraOption(String firstNetworkExtraOption) {
        this.firstNetworkExtraOption = firstNetworkExtraOption;
    }

    public String getFirstNetworkNetdevOption() {
        return firstNetworkNetdevOption;
    }

    public void setFirstNetworkNetdevOption(String firstNetworkNetdevOption) {
        this.firstNetworkNetdevOption = firstNetworkNetdevOption;
    }

    public String getSecondNetworkNICOption() {
        return secondNetworkNICOption;
    }

    public void setSecondNetworkNICOption(String secondNetworkNICOption) {
        this.secondNetworkNICOption = secondNetworkNICOption;
    }

    public String getSecondNetworkExtraOption() {
        return secondNetworkExtraOption;
    }

    public void setSecondNetworkExtraOption(String secondNetworkExtraOption) {
        this.secondNetworkExtraOption = secondNetworkExtraOption;
    }

    public String getSecondNetworkNetdevOption() {
        return secondNetworkNetdevOption;
    }

    public void setSecondNetworkNetdevOption(String secondNetworkNetdevOption) {
        this.secondNetworkNetdevOption = secondNetworkNetdevOption;
    }

    public String getThirdNetworkNICOption() {
        return thirdNetworkNICOption;
    }

    public void setThirdNetworkNICOption(String thirdNetworkNICOption) {
        this.thirdNetworkNICOption = thirdNetworkNICOption;
    }

    public String getThirdNetworkExtraOption() {
        return thirdNetworkExtraOption;
    }

    public void setThirdNetworkExtraOption(String thirdNetworkExtraOption) {
        this.thirdNetworkExtraOption = thirdNetworkExtraOption;
    }

    public String getThirdNetworkNetdevOption() {
        return thirdNetworkNetdevOption;
    }

    public void setThirdNetworkNetdevOption(String thirdNetworkNetdevOption) {
        this.thirdNetworkNetdevOption = thirdNetworkNetdevOption;
    }

    public String getFourthNetworkNICOption() {
        return fourthNetworkNICOption;
    }

    public void setFourthNetworkNICOption(String fourthNetworkNICOption) {
        this.fourthNetworkNICOption = fourthNetworkNICOption;
    }

    public String getFourthNetworkExtraOption() {
        return fourthNetworkExtraOption;
    }

    public void setFourthNetworkExtraOption(String fourthNetworkExtraOption) {
        this.fourthNetworkExtraOption = fourthNetworkExtraOption;
    }

    public String getFourthNetworkNetdevOption() {
        return fourthNetworkNetdevOption;
    }

    public void setFourthNetworkNetdevOption(String fourthNetworkNetdevOption) {
        this.fourthNetworkNetdevOption = fourthNetworkNetdevOption;
    }

    public String getFifthNetworkNICOption() {
        return fifthNetworkNICOption;
    }

    public void setFifthNetworkNICOption(String fifthNetworkNICOption) {
        this.fifthNetworkNICOption = fifthNetworkNICOption;
    }

    public String getFifthNetworkExtraOption() {
        return fifthNetworkExtraOption;
    }

    public void setFifthNetworkExtraOption(String fifthNetworkExtraOption) {
        this.fifthNetworkExtraOption = fifthNetworkExtraOption;
    }

    public String getFifthNetworkNetdevOption() {
        return fifthNetworkNetdevOption;
    }

    public void setFifthNetworkNetdevOption(String fifthNetworkNetdevOption) {
        this.fifthNetworkNetdevOption = fifthNetworkNetdevOption;
    }

    public String getSixthNetworkNICOption() {
        return sixthNetworkNICOption;
    }

    public void setSixthNetworkNICOption(String sixthNetworkNICOption) {
        this.sixthNetworkNICOption = sixthNetworkNICOption;
    }

    public String getSixthNetworkExtraOption() {
        return sixthNetworkExtraOption;
    }

    public void setSixthNetworkExtraOption(String sixthNetworkExtraOption) {
        this.sixthNetworkExtraOption = sixthNetworkExtraOption;
    }

    public String getSixthNetworkNetdevOption() {
        return sixthNetworkNetdevOption;
    }

    public void setSixthNetworkNetdevOption(String sixthNetworkNetdevOption) {
        this.sixthNetworkNetdevOption = sixthNetworkNetdevOption;
    }

    public String getSeventhNetworkNICOption() {
        return seventhNetworkNICOption;
    }

    public void setSeventhNetworkNICOption(String seventhNetworkNICOption) {
        this.seventhNetworkNICOption = seventhNetworkNICOption;
    }

    public String getSeventhNetworkExtraOption() {
        return seventhNetworkExtraOption;
    }

    public void setSeventhNetworkExtraOption(String seventhNetworkExtraOption) {
        this.seventhNetworkExtraOption = seventhNetworkExtraOption;
    }

    public String getSeventhNetworkNetdevOption() {
        return seventhNetworkNetdevOption;
    }

    public void setSeventhNetworkNetdevOption(String seventhNetworkNetdevOption) {
        this.seventhNetworkNetdevOption = seventhNetworkNetdevOption;
    }

    public String getEighthNetworkNICOption() {
        return eighthNetworkNICOption;
    }

    public void setEighthNetworkNICOption(String eighthNetworkNICOption) {
        this.eighthNetworkNICOption = eighthNetworkNICOption;
    }

    public String getEighthNetworkExtraOption() {
        return eighthNetworkExtraOption;
    }

    public void setEighthNetworkExtraOption(String eighthNetworkExtraOption) {
        this.eighthNetworkExtraOption = eighthNetworkExtraOption;
    }

    public String getEighthNetworkNetdevOption() {
        return eighthNetworkNetdevOption;
    }

    public void setEighthNetworkNetdevOption(String eighthNetworkNetdevOption) {
        this.eighthNetworkNetdevOption = eighthNetworkNetdevOption;
    }

    public String getNinthNetworkNICOption() {
        return ninthNetworkNICOption;
    }

    public void setNinthNetworkNICOption(String ninthNetworkNICOption) {
        this.ninthNetworkNICOption = ninthNetworkNICOption;
    }

    public String getNinthNetworkExtraOption() {
        return ninthNetworkExtraOption;
    }

    public void setNinthNetworkExtraOption(String ninthNetworkExtraOption) {
        this.ninthNetworkExtraOption = ninthNetworkExtraOption;
    }

    public String getNinthNetworkNetdevOption() {
        return ninthNetworkNetdevOption;
    }

    public void setNinthNetworkNetdevOption(String ninthNetworkNetdevOption) {
        this.ninthNetworkNetdevOption = ninthNetworkNetdevOption;
    }

    public String getTenthNetworkNICOption() {
        return tenthNetworkNICOption;
    }

    public void setTenthNetworkNICOption(String tenthNetworkNICOption) {
        this.tenthNetworkNICOption = tenthNetworkNICOption;
    }

    public String getTenthNetworkExtraOption() {
        return tenthNetworkExtraOption;
    }

    public void setTenthNetworkExtraOption(String tenthNetworkExtraOption) {
        this.tenthNetworkExtraOption = tenthNetworkExtraOption;
    }

    public String getTenthNetworkNetdevOption() {
        return tenthNetworkNetdevOption;
    }

    public void setTenthNetworkNetdevOption(String tenthNetworkNetdevOption) {
        this.tenthNetworkNetdevOption = tenthNetworkNetdevOption;
    }

    public String getRtcOption() {
        return rtcOption;
    }

    public void setRtcOption(String rtcOption) {
        this.rtcOption = rtcOption;
    }

    public String getNameOption() {
        return nameOption;
    }

    public void setNameOption(String nameOption) {
        this.nameOption = nameOption;
    }

    public String getSnapshotOption() {
        return snapshotOption;
    }

    public void setSnapshotOption(String snapshotOption) {
        this.snapshotOption = snapshotOption;
    }

    public String getNoFdBootchkOption() {
        return noFdBootchkOption;
    }

    public void setNoFdBootchkOption(String noFdBootchkOption) {
        this.noFdBootchkOption = noFdBootchkOption;
    }

    public String getNoHpetOption() {
        return noHpetOption;
    }

    public void setNoHpetOption(String noHpetOption) {
        this.noHpetOption = noHpetOption;
    }

    public String getMtdblockOption() {
        return mtdblockOption;
    }

    public void setMtdblockOption(String mtdblockOption) {
        this.mtdblockOption = mtdblockOption;
    }

    public String getSdOption() {
        return sdOption;
    }

    public void setSdOption(String sdOption) {
        this.sdOption = sdOption;
    }

    public String getPflashOption() {
        return pflashOption;
    }

    public void setPflashOption(String pflashOption) {
        this.pflashOption = pflashOption;
    }

    public String getMonitorOption() {
        return monitorOption;
    }

    public void setMonitorOption(String monitorOption) {
        this.monitorOption = monitorOption;
    }

    public String getQmpOption() {
        return qmpOption;
    }

    public void setQmpOption(String qmpOption) {
        this.qmpOption = qmpOption;
    }

    public String getUsbDriverOption() {
        return usbDriverOption;
    }

    public void setUsbDriverOption(String usbDriverOption) {
        this.usbDriverOption = usbDriverOption;
    }

    public String getUsbMouseOption() {
        return usbMouseOption;
    }

    public void setUsbMouseOption(String usbMouseOption) {
        this.usbMouseOption = usbMouseOption;
    }

    public String getUsbTabletOption() {
        return usbTabletOption;
    }

    public void setUsbTabletOption(String usbTabletOption) {
        this.usbTabletOption = usbTabletOption;
    }

    public String getUsbWacomTabletOption() {
        return usbWacomTabletOption;
    }

    public void setUsbWacomTabletOption(String usbWacomTabletOption) {
        this.usbWacomTabletOption = usbWacomTabletOption;
    }

    public String getUsbKeyboardOption() {
        return usbKeyboardOption;
    }

    public void setUsbKeyboardOption(String usbKeyboardOption) {
        this.usbKeyboardOption = usbKeyboardOption;
    }

    public String getUsbBrailleOption() {
        return usbBrailleOption;
    }

    public void setUsbBrailleOption(String usbBrailleOption) {
        this.usbBrailleOption = usbBrailleOption;
    }

    public String getUsbDiskOption() {
        return usbDiskOption;
    }

    public void setUsbDiskOption(String usbDiskOption) {
        this.usbDiskOption = usbDiskOption;
    }

    public String getUsbSerialOption() {
        return usbSerialOption;
    }

    public void setUsbSerialOption(String usbSerialOption) {
        this.usbSerialOption = usbSerialOption;
    }

    public String getUsbNetOption() {
        return usbNetOption;
    }

    public void setUsbNetOption(String usbNetOption) {
        this.usbNetOption = usbNetOption;
    }

    public String getKernelBootOption() {
        return kernelBootOption;
    }

    public void setKernelBootOption(String kernelBootOption) {
        this.kernelBootOption = kernelBootOption;
    }

    public String getCustomOptions() {
        return customOptions;
    }

    public void setCustomOptions(String customOptions) {
        this.customOptions = customOptions;
    }
}
