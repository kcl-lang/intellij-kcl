/**
 * KusionStack. Copyright (c) 2020-2020 All Rights Reserved.
 */
package io.kusionstack.kcl.util;

/**
 * @author amyxia
 * @version ExecuteResult: ExecuteResult.java, v 0.1 2020年11月06日 1:54 上午 amyxia Exp $
 */
public class ExecuteResult {
    private String  stdout;
    private String  stderr;
    private boolean success;
    private int     exitValue;

    public ExecuteResult(String stdout, String stderr, boolean success, int exitValue) {
        this.stdout = stdout;
        this.stderr = stderr;
        this.success = success;
        this.exitValue = exitValue;
    }

    /**
     * Getter method for property <tt>stdout</tt>.
     *
     * @return property value of stdout
     */
    public String getStdout() {
        return stdout;
    }

    /**
     * Setter method for property <tt>stdout</tt>.
     *
     * @param stdout value to be assigned to property stdout
     */
    public void setStdout(String stdout) {
        this.stdout = stdout;
    }

    /**
     * Getter method for property <tt>stderr</tt>.
     *
     * @return property value of stderr
     */
    public String getStderr() {
        return stderr;
    }

    /**
     * Setter method for property <tt>stderr</tt>.
     *
     * @param stderr value to be assigned to property stderr
     */
    public void setStderr(String stderr) {
        this.stderr = stderr;
    }

    /**
     * Getter method for property <tt>success</tt>.
     *
     * @return property value of success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Setter method for property <tt>success</tt>.
     *
     * @param success value to be assigned to property success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Getter method for property <tt>exitValue</tt>.
     *
     * @return property value of exitValue
     */
    public int getExitValue() {
        return exitValue;
    }

    /**
     * Setter method for property <tt>exitValue</tt>.
     *
     * @param exitValue value to be assigned to property exitValue
     */
    public void setExitValue(int exitValue) {
        this.exitValue = exitValue;
    }

    public static ExecuteResult KCLNotInstalled() {
        return new ExecuteResult(null, "kcl not installed", false, 1);
    }

    public static ExecuteResult success(String stdout) {
        return new ExecuteResult(stdout, null, true, 0);
    }

    public static ExecuteResult fail(String stderr, int exitValue) {
        return new ExecuteResult(null, stderr, false, exitValue);
    }
}