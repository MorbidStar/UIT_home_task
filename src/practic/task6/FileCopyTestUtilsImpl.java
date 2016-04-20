package practic.task6;

import nedis.study.interfaces.t6.io.FileCopyTestUtils;
import nedis.study.interfaces.t6.io.FileCopyUtils;

public class FileCopyTestUtilsImpl implements FileCopyTestUtils {

	@Override
	public FileCopyUtils createSimpleFileCopyUtils() {
		FileCopyUtils result = new FileCopyUtilsImpl();
		return result;
	}

	@Override
	public FileCopyUtils createBufferedFileCopyUtils() {
		FileCopyUtils result = new FileCopyUtilsBufImpl();
		return result;
	}

	@Override
	public FileCopyUtils createChannelsFileCopyUtils() {
		FileCopyUtils result = new FileCopyUtilsCanImpl();
		return result;
	}

	@Override
	public FileCopyUtils createJava7CopyUtils() {
		FileCopyUtils result = new FileCopyUtilsJava7Impl();
		return result;
	}

}
