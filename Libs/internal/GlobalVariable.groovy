package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object sspathP17
     
    /**
     * <p></p>
     */
    public static Object kode_event
     
    /**
     * <p></p>
     */
    public static Object user
     
    /**
     * <p></p>
     */
    public static Object pass
     
    /**
     * <p></p>
     */
    public static Object screenshotPathKredit
     
    /**
     * <p></p>
     */
    public static Object screenshotPathMiniMax
     
    /**
     * <p></p>
     */
    public static Object screenshotPathBudget
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters(), selectedVariables)
    
            sspathP17 = selectedVariables['sspathP17']
            kode_event = selectedVariables['kode_event']
            user = selectedVariables['user']
            pass = selectedVariables['pass']
            screenshotPathKredit = selectedVariables['screenshotPathKredit']
            screenshotPathMiniMax = selectedVariables['screenshotPathMiniMax']
            screenshotPathBudget = selectedVariables['screenshotPathBudget']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
