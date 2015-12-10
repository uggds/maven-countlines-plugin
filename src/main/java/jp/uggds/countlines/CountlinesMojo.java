package jp.uggds.countlines;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.IOException;

/**
 * @auther uga
 */
@Mojo(name = "countlines")
public class CountlinesMojo extends AbstractMojo{
    /**
     * select directory.
     *
     * @parameter expression="${dir}"
     * @required
     */
    @Parameter(required = true)
    protected String dir;

    /**
     * select extension.
     *
     * @parameter expression="${ext}"
     * @required
     */
    @Parameter(required = true)
    protected String ext;

    public void execute() throws MojoExecutionException, MojoFailureException {

        File directory = new File(dir);
        if (!directory.isDirectory()) {
            throw new MojoFailureException("ディレクトリではないか、または存在しません。");
        }
        String[] extensions = ext.split(",");
        // 指定されたディレクトリ以下の指定された拡張子の
        // ファイルの行数をカウントする
        CountExecuter executer = new CountExecuter(directory, extensions);

        try {
            executer.count();
        } catch (IOException e) {
            throw new MojoExecutionException(e.getMessage());
        }
    }
}
