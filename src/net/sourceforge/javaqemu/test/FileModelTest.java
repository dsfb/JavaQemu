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
    public ResourceFile res = new ResourceFile("/echo.txt");
	
	@Rule
    public ResourceFile resTestVM = new ResourceFile("/TestVM.xml");
	
	private FileModel fileModel = new FileModel();
	
	@Test
    public void testTextFileExistence() throws Exception
    {
        assertTrue(res.getContent().length() > 0);
        assertTrue(res.getFile().exists());
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

	@Test
	public void testReadXML() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadConfigurationFromXML() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveToXML() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveConfigurationToXML() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMachineName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFirstHardDiskOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSecondHardDiskOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMachineType() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMachineType() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMachineName() {
		try {
			fileModel.readXML(resTestVM.getFile().getAbsolutePath());
		} catch(IOException e) {
			fail("IOException!");
		}
		
		assertEquals(fileModel.getMachineName(), "TestVM");
	}

	@Test
	public void testGetFirstHardDiskOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSecondHardDiskOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetThirdHardDiskOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetThirdHardDiskOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFourthHardDiskOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFourthHardDiskOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testChecks_extension() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRamSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetRamSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetConfiguration() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetConfiguration() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDefaultVMPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDefaultVMPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetExecute_before_start_qemu() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetExecute_before_start_qemu() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetQemu_executable_path() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetQemu_executable_path() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetExecute_after_stop_qemu() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetExecute_after_stop_qemu() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetQemu_img_executable_path() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetQemu_img_executable_path() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBios_vga_bios_keymaps_path() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBios_vga_bios_keymaps_path() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDisplayType() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDisplayType() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNographicOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNographicOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetVgaType() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetVgaType() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFullscreenOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFullscreenOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetWin2khackOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetWin2khackOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNoacpiOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNoacpiOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMachineAccel1() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMachineAccel1() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMachineAccel2() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMachineAccel2() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMachineAccel3() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMachineAccel3() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMachineKernel_irpchip() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMachineKernel_irpchip() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMachineKvm_shadow_mem() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMachineKvm_shadow_mem() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMachineDump_guest_core() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMachineDump_guest_core() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMachineMem_merge() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMachineMem_merge() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCpuModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCpuModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCpuidFlags() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCpuidFlags() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCdrom() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCdrom() {
		fail("Not yet implemented");
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
	public void testGetSmpCpusNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSmpCpusNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSmpCoresNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSmpCoresNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSmpThreadsNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSmpThreadsNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSmpSocketsNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSmpSocketsNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSmpCpusMaxNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSmpCpusMaxNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFirstNumaNodeMem() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFirstNumaNodeMem() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFirstNumaNodeCpus() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFirstNumaNodeCpus() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSecondNumaNodeMem() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSecondNumaNodeMem() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSecondNumaNodeCpus() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSecondNumaNodeCpus() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetThirdNumaNodeMem() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetThirdNumaNodeMem() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetThirdNumaNodeCpus() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetThirdNumaNodeCpus() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFourthNumaNodeMem() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFourthNumaNodeMem() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFourthNumaNodeCpus() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFourthNumaNodeCpus() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFifthNumaNodeMem() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFifthNumaNodeMem() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFifthNumaNodeCpus() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFifthNumaNodeCpus() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSixthNumaNodeMem() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSixthNumaNodeMem() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSixthNumaNodeCpus() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSixthNumaNodeCpus() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSeventhNumaNodeMem() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSeventhNumaNodeMem() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSeventhNumaNodeCpus() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSeventhNumaNodeCpus() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEighthNumaNodeMem() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEighthNumaNodeMem() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEighthNumaNodeCpus() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEighthNumaNodeCpus() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNinthNumaNodeMem() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNinthNumaNodeMem() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNinthNumaNodeCpus() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNinthNumaNodeCpus() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTenthNumaNodeMem() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTenthNumaNodeMem() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTenthNumaNodeCpus() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTenthNumaNodeCpus() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNoFrameOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNoFrameOption() {
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
	public void testGetFirstNetworkNICOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFirstNetworkNICOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFirstNetworkExtraOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFirstNetworkExtraOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFirstNetworkNetdevOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFirstNetworkNetdevOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSecondNetworkNICOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSecondNetworkNICOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSecondNetworkExtraOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSecondNetworkExtraOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSecondNetworkNetdevOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSecondNetworkNetdevOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetThirdNetworkNICOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetThirdNetworkNICOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetThirdNetworkExtraOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetThirdNetworkExtraOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetThirdNetworkNetdevOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetThirdNetworkNetdevOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFourthNetworkNICOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFourthNetworkNICOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFourthNetworkExtraOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFourthNetworkExtraOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFourthNetworkNetdevOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFourthNetworkNetdevOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFifthNetworkNICOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFifthNetworkNICOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFifthNetworkExtraOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFifthNetworkExtraOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFifthNetworkNetdevOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFifthNetworkNetdevOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSixthNetworkNICOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSixthNetworkNICOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSixthNetworkExtraOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSixthNetworkExtraOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSixthNetworkNetdevOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSixthNetworkNetdevOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSeventhNetworkNICOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSeventhNetworkNICOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSeventhNetworkExtraOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSeventhNetworkExtraOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSeventhNetworkNetdevOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSeventhNetworkNetdevOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEighthNetworkNICOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEighthNetworkNICOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEighthNetworkExtraOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEighthNetworkExtraOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEighthNetworkNetdevOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEighthNetworkNetdevOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNinthNetworkNICOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNinthNetworkNICOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNinthNetworkExtraOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNinthNetworkExtraOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNinthNetworkNetdevOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNinthNetworkNetdevOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTenthNetworkNICOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTenthNetworkNICOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTenthNetworkExtraOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTenthNetworkExtraOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTenthNetworkNetdevOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTenthNetworkNetdevOption() {
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
		fail("Not yet implemented");
	}

	@Test
	public void testSetUsbBrailleOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUsbDiskOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUsbDiskOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUsbSerialOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUsbSerialOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUsbNetOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUsbNetOption() {
		fail("Not yet implemented");
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

	@Test
	public void testObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotify() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testWait() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalize() {
		fail("Not yet implemented");
	}

}
