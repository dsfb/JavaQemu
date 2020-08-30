package net.sourceforge.javaqemu.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import net.sourceforge.javaqemu.model.FileModel;

public class FileModelTest {

	@Rule
    public ResourceFile resTestVM = new ResourceFile("/TestVM.xml");

	@Rule
	public ResourceFile successTestVM = new ResourceFile("/testSuccess.xml");

	@Rule
	public ResourceFile resConfSW = new ResourceFile("/JavaQemuConfig.xml");

	@Rule
	public ResourceFile successConfSW = new ResourceFile("/confSuccess.xml");

	private FileModel fileModel = new FileModel();

	@Test
    public void testTestVmFileExistence() throws Exception
    {
        assertTrue(resTestVM.getContent().length() > 0);
        assertTrue(resTestVM.getFile().exists());
    }

	@Test
    public void testTestConfigFileExistence() throws Exception
    {
        assertTrue(resConfSW.getContent().length() > 0);
        assertTrue(resConfSW.getFile().exists());
    }

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		fileModel = new FileModel();
	}

	public void useSuccessTestFile() throws IOException {
		fileModel.saveToXML(successTestVM.getFile().getAbsolutePath());

		fileModel.readXML(successTestVM.getFile().getAbsolutePath());
	}
	
	public void readTestVM() throws IOException {
		fileModel.readXML(resTestVM.getFile().getAbsolutePath());
	}
	
	public void readConfig() throws IOException {
		fileModel.readConfigurationFromXML(resConfSW.getFile().getAbsolutePath());
	}
	
	@Test
	public void testSetMachineName() {
		try {
			readTestVM();

			assertEquals(fileModel.getMachineName(), "TestVM");

			fileModel.setMachineName("NewVM");

			useSuccessTestFile();

			assertEquals(fileModel.getMachineName(), "NewVM");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testSetFirstHardDiskOption() {
		try {
			readTestVM();

			assertEquals(fileModel.getFirstHardDiskOption(), 
					"/home/daniel/Documentos/Qemu VMs/TestVM/TestVM.vdi");

			fileModel.setFirstHardDiskOption("/home/daniel/Documentos/Qemu VMs/TestVM/NewVM.vdi");

			useSuccessTestFile();

			assertEquals(fileModel.getFirstHardDiskOption(),
					"/home/daniel/Documentos/Qemu VMs/TestVM/NewVM.vdi");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testSetMachineType() {
		try {
			readTestVM();

			assertEquals(fileModel.getMachineType(), "pc");

			fileModel.setMachineType("q35");

			useSuccessTestFile();

			assertEquals(fileModel.getMachineType(), "q35");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testChecks_extension() {
		String pathLinux = "/home/javaqemu/Documents/MyVM.xml";
		assertEquals(fileModel.checks_extension(pathLinux), "/");
		
		String pathWindows = "C:\\windows";
		assertEquals(fileModel.checks_extension(pathWindows), "\\");
	}

	@Test
	public void testSetRamSize() {
		try {
			readTestVM();

			assertEquals(fileModel.getRamSize(),
					"128.000");

			fileModel.setRamSize("196");

			useSuccessTestFile();

			assertEquals(fileModel.getRamSize(), "196");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testSetDefaultVMPath() {
		try {
			readConfig();

			assertEquals(fileModel.getDefaultVMPath(),
					"/home/daniel/Documentos/Qemu VMs");

			fileModel.setDefaultVMPath("/home/daniel/Documentos/New Qemu VMs");

			useSuccessTestFile();

			assertEquals(fileModel.getDefaultVMPath(), 
					"/home/daniel/Documentos/New Qemu VMs");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testSetQemu_executable_path() {
		try {
			readConfig();

			assertEquals(fileModel.getQemu_executable_path(),
					"/usr/bin/qemu-system-x86_64");

			fileModel.setQemu_executable_path("/usr/bin/qemu-system-i386");

			useSuccessTestFile();

			assertEquals(fileModel.getQemu_executable_path(), 
					"/usr/bin/qemu-system-i386");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetQemu_img_executable_path() {
		try {
			readConfig();

			assertEquals(fileModel.getQemu_img_executable_path(),
					"/usr/bin/qemu-img");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetBios_vga_bios_keymaps_path() {
		try {
			readConfig();

			assertEquals(fileModel.getBios_vga_bios_keymaps_path(),
					"/usr/share/qemu");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetNographicOption() {
		try {
			readTestVM();

			assertEquals(fileModel.getNographicOption(),
					"false");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testSetVgaType() {
		try {
			readTestVM();

			assertEquals(fileModel.getVgaType(), "cirrus");

			fileModel.setVgaType("qxl");

			useSuccessTestFile();

			assertEquals(fileModel.getVgaType(), "qxl");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetFullscreenOption() {
		try {
			readTestVM();

			assertEquals(fileModel.getFullscreenOption(),
					"false");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetWin2khackOption() {
		try {
			readTestVM();

			assertEquals(fileModel.getWin2khackOption(),
					"true");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetNoacpiOption() {
		try {
			readTestVM();

			assertEquals(fileModel.getNoacpiOption(),
					"true");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetMachineAccel1() {
		try {
			readTestVM();

			assertEquals(fileModel.getMachineAccel1(),
					"kvm");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetMachineAccel2() {
		try {
			readTestVM();

			assertEquals(fileModel.getMachineAccel2(),
					"tcg");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetMachineAccel3() {
		try {
			readTestVM();

			assertEquals(fileModel.getMachineAccel3(),
					"xen");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetMachineKvm_shadow_mem() {
		try {
			readTestVM();

			assertEquals(fileModel.getMachineKvm_shadow_mem(),
					"0");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testSetCpuModel() {
		try {
			readTestVM();

			assertEquals(fileModel.getCpuModel(), "core2duo");

			fileModel.setCpuModel("qemu64");

			useSuccessTestFile();

			assertEquals(fileModel.getCpuModel(), "qemu64");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testSetCpuidFlags() {
		try {
			readTestVM();

			assertEquals(fileModel.getCpuidFlags(),
					",+sse2,+sse,+acpi,+fpu,+sse4_1,+sse4.1,+sse4_2,+sse4.2,+ssse3,+sse3,+avx2,+3dnow,+3dnowext,+i64");

			fileModel.setCpuidFlags(",+sse2,+sse,+acpi,+fpu,+sse4_1");

			useSuccessTestFile();

			assertEquals(fileModel.getCpuidFlags(), ",+sse2,+sse,+acpi,+fpu,+sse4_1");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testSetCdrom() {
		try {
			readTestVM();

			assertEquals(fileModel.getCdrom(),
					"/home/daniel/Downloads/isos/Core-11.1.iso");

			fileModel.setCdrom("/home/daniel/Downloads/isos/Core-11.0.iso");

			useSuccessTestFile();

			assertEquals(fileModel.getCdrom(), "/home/daniel/Downloads/isos/Core-11.0.iso");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testSetBootOrder1() {
		try {
			readTestVM();

			assertEquals(fileModel.getBootOrder1(),
					"d");

			fileModel.setBootOrder1("c");

			useSuccessTestFile();

			assertEquals(fileModel.getBootOrder1(), "c");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testSetBootOrder2() {
		try {
			readTestVM();

			assertEquals(fileModel.getBootOrder2(),
					"c");

			fileModel.setBootOrder2("d");

			useSuccessTestFile();

			assertEquals(fileModel.getBootOrder2(), "d");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testSetBootOrder3() {
		try {
			readTestVM();

			assertNull(fileModel.getBootOrder3());

			fileModel.setBootOrder3("b");

			useSuccessTestFile();

			assertEquals(fileModel.getBootOrder3(), "b");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testSetBootOnce1() {
		try {
			readTestVM();

			assertEquals(fileModel.getBootOnce1(),
					"c");

			fileModel.setBootOnce1("b");

			useSuccessTestFile();

			assertEquals(fileModel.getBootOnce1(), "b");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testSetBootOnce2() {
		try {
			readTestVM();

			assertEquals(fileModel.getBootOnce2(),
					"d");

			fileModel.setBootOnce2("a");

			useSuccessTestFile();

			assertEquals(fileModel.getBootOnce2(), "a");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testSetBootOnce3() {
		try {
			readTestVM();

			assertNull(fileModel.getBootOnce3());

			fileModel.setBootOnce3("a");

			useSuccessTestFile();

			assertEquals(fileModel.getBootOnce3(), "a");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetBootMenu() {
		try {
			readTestVM();

			assertNull(fileModel.getBootMenu());
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetBootSplash() {
		try {
			readTestVM();

			assertNull(fileModel.getBootSplash());
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetBootSplashTime() {
		try {
			readTestVM();

			assertNull(fileModel.getBootSplashTime());
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetBootRebootTimeout() {
		try {
			readTestVM();

			assertNull(fileModel.getBootRebootTimeout());
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetBootStrict() {
		try {
			readTestVM();

			assertNull(fileModel.getBootStrict());
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testSetKeyboardLayoutLanguage() {
		try {
			readTestVM();

			assertEquals(fileModel.getKeyboardLayoutLanguage(),
					"pt-br");

			fileModel.setKeyboardLayoutLanguage("en-us");

			useSuccessTestFile();

			assertEquals(fileModel.getKeyboardLayoutLanguage(), "en-us");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testSetSoundHardwareOption() {
		try {
			readTestVM();

			assertEquals(fileModel.getSoundHardwareOption(),
					"sb16");

			fileModel.setSoundHardwareOption("ac97");

			useSuccessTestFile();

			assertEquals(fileModel.getSoundHardwareOption(), "ac97");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetRtcOption() {
		try {
			readTestVM();

			assertEquals(fileModel.getRtcOption(),
					"base=utc");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testSetNameOption() {
		try {
			readTestVM();

			assertEquals(fileModel.getNameOption(),
					"TestVM");

			fileModel.setNameOption("MyVM");

			useSuccessTestFile();

			assertEquals(fileModel.getNameOption(), "MyVM");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testSetSnapshotOption() {
		try {
			readTestVM();

			assertEquals(fileModel.getSnapshotOption(),
					"false");

			fileModel.setSnapshotOption("true");

			useSuccessTestFile();

			assertEquals(fileModel.getSnapshotOption(), "true");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testSetNoFdBootchkOption() {
		try {
			readTestVM();

			assertEquals(fileModel.getNoFdBootchkOption(),
					"true");

			fileModel.setNoFdBootchkOption("false");

			useSuccessTestFile();

			assertEquals(fileModel.getNoFdBootchkOption(), "false");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testSetNoHpetOption() {
		try {
			readTestVM();

			assertEquals(fileModel.getNoHpetOption(),
					"true");

			fileModel.setNoHpetOption("false");

			useSuccessTestFile();

			assertEquals(fileModel.getNoHpetOption(), "false");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetMtdblockOption() {
		try {
			readTestVM();

			assertNull(fileModel.getMtdblockOption());
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetSdOption() {
		try {
			readTestVM();

			assertNull(fileModel.getSdOption());
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetPflashOption() {
		try {
			readTestVM();

			assertNull(fileModel.getPflashOption());
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetMonitorOption() {
		try {
			readTestVM();

			assertNull(fileModel.getMonitorOption());
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetQmpOption() {
		try {
			readTestVM();

			assertNull(fileModel.getQmpOption());
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testSetUsbDriverOption() {
		try {
			readTestVM();

			assertEquals(fileModel.getUsbDriverOption(),
					"false");

			fileModel.setUsbDriverOption("true");

			useSuccessTestFile();

			assertEquals(fileModel.getUsbDriverOption(), "true");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

@Test
	public void testSetUsbMouseOption() {
		try {
			readTestVM();
	
			assertEquals(fileModel.getUsbMouseOption(),
					"true");
	
			fileModel.setUsbMouseOption("false");
	
			useSuccessTestFile();
	
			assertEquals(fileModel.getUsbMouseOption(), "false");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetUsbTabletOption() {
		try {
			readTestVM();

			assertNull(fileModel.getUsbTabletOption());

			fileModel.setUsbTabletOption("true");

			useSuccessTestFile();

			assertEquals(fileModel.getUsbTabletOption(), "true");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testSetUsbWacomTabletOption() {
		try {
			readTestVM();

			assertEquals(fileModel.getUsbWacomTabletOption(),
					"false");

			fileModel.setUsbWacomTabletOption("true");

			useSuccessTestFile();

			assertEquals(fileModel.getUsbWacomTabletOption(), "true");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testSetUsbKeyboardOption() {
		try {
			readTestVM();

			assertEquals(fileModel.getUsbKeyboardOption(),
					"false");

			fileModel.setUsbKeyboardOption("true");

			useSuccessTestFile();

			assertEquals(fileModel.getUsbKeyboardOption(), "true");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetUsbBrailleOption() {
		try {
			readTestVM();

			assertEquals(fileModel.getUsbBrailleOption(), 
					"false");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetKernelBootOption() {
		try {
			readTestVM();

			assertNull(fileModel.getKernelBootOption());
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetCustomOptions() {
		try {
			readTestVM();

			assertNull(fileModel.getCustomOptions());
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}
}
