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
		fail("Not yet implemented");
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
			fileModel.readXML(resConfSW.getFile().getAbsolutePath());

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
			fileModel.readXML(resConfSW.getFile().getAbsolutePath());

			assertEquals(fileModel.getQemu_img_executable_path(),
					"/usr/bin/qemu-img");
		} catch(IOException e) {
			fail("IOException at this single testCase!");
		}
	}

	@Test
	public void testGetBios_vga_bios_keymaps_path() {
		try {
			fileModel.readXML(resConfSW.getFile().getAbsolutePath());

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
	public void testGetFloppyDiskA() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFloppyDiskA() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFloppyDiskB() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFloppyDiskB() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBootOrder1() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBootOrder1() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBootOrder2() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBootOrder2() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBootOrder3() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBootOrder3() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBootOnce1() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBootOnce1() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBootOnce2() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBootOnce2() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBootOnce3() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBootOnce3() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBootMenu() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBootMenu() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBootSplash() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBootSplash() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBootSplashTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBootSplashTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBootRebootTimeout() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBootRebootTimeout() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBootStrict() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBootStrict() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetKeyboardLayoutLanguage() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetKeyboardLayoutLanguage() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSoundHardwareOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSoundHardwareOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMemPathOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMemPathOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMemPreallocOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMemPreallocOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRtcOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetRtcOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNameOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNameOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSnapshotOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSnapshotOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNoFdBootchkOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNoFdBootchkOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNoHpetOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNoHpetOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMtdblockOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMtdblockOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSdOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSdOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPflashOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPflashOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMonitorOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMonitorOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetQmpOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetQmpOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUsbDriverOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUsbDriverOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUsbMouseOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUsbMouseOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUsbTabletOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUsbTabletOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUsbWacomTabletOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUsbWacomTabletOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUsbKeyboardOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUsbKeyboardOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUsbBrailleOption() {
		
	}

	@Test
	public void testGetKernelBootOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetKernelBootOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCustomOptions() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCustomOptions() {
		fail("Not yet implemented");
	}
}
