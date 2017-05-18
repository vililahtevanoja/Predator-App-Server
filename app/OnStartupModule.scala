import com.google.inject.AbstractModule

class OnStartupModule extends AbstractModule {
  override def configure() = {
    bind(classOf[DatabaseOnStartup]).asEagerSingleton()
  }
}