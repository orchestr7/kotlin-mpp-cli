import com.akuleshov7.cli.buildutils.configureDiktat
import com.akuleshov7.cli.buildutils.configurePublishing
import com.akuleshov7.cli.buildutils.configureVersioning
import com.akuleshov7.cli.buildutils.createDetektTask
import com.akuleshov7.cli.buildutils.installGitHooks

// version generation
configureVersioning()
// checks and validations
configureDiktat()
createDetektTask()
installGitHooks()
// publishing to maven central
configurePublishing()
