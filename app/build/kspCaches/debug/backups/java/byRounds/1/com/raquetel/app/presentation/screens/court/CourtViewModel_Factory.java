package com.raquetel.app.presentation.screens.court;

import com.raquetel.app.domain.usecases.court.GetCourtsUseCase;
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
public final class CourtViewModel_Factory implements Factory<CourtViewModel> {
  private final Provider<GetCourtsUseCase> getCourtsUseCaseProvider;

  public CourtViewModel_Factory(Provider<GetCourtsUseCase> getCourtsUseCaseProvider) {
    this.getCourtsUseCaseProvider = getCourtsUseCaseProvider;
  }

  @Override
  public CourtViewModel get() {
    return newInstance(getCourtsUseCaseProvider.get());
  }

  public static CourtViewModel_Factory create(Provider<GetCourtsUseCase> getCourtsUseCaseProvider) {
    return new CourtViewModel_Factory(getCourtsUseCaseProvider);
  }

  public static CourtViewModel newInstance(GetCourtsUseCase getCourtsUseCase) {
    return new CourtViewModel(getCourtsUseCase);
  }
}
