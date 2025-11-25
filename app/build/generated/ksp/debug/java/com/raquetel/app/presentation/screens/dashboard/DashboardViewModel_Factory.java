package com.raquetel.app.presentation.screens.dashboard;

import com.raquetel.app.domain.usecases.booking.GetBookingsUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class DashboardViewModel_Factory implements Factory<DashboardViewModel> {
  private final Provider<GetBookingsUseCase> getBookingsUseCaseProvider;

  public DashboardViewModel_Factory(Provider<GetBookingsUseCase> getBookingsUseCaseProvider) {
    this.getBookingsUseCaseProvider = getBookingsUseCaseProvider;
  }

  @Override
  public DashboardViewModel get() {
    return newInstance(getBookingsUseCaseProvider.get());
  }

  public static DashboardViewModel_Factory create(
      Provider<GetBookingsUseCase> getBookingsUseCaseProvider) {
    return new DashboardViewModel_Factory(getBookingsUseCaseProvider);
  }

  public static DashboardViewModel newInstance(GetBookingsUseCase getBookingsUseCase) {
    return new DashboardViewModel(getBookingsUseCase);
  }
}
