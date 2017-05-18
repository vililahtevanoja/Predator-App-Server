import javax.inject.Inject

import filters.LoggingFilter
import play.filters.cors.CORSFilter;
import play.api.http.DefaultHttpFilters

class Filters @Inject()(log: LoggingFilter, cors: CORSFilter) extends DefaultHttpFilters(log, cors) {
}
