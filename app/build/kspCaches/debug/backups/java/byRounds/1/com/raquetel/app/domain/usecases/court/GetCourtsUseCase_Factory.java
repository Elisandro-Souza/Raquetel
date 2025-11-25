package com.raquetel.app.domain.usecases.court;

import com.raquetel.app.domain.repositories.CourtRepository;
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
public final class GetCourtsUseCase_Factory implements Factory<GetCourtsUseCase> {
  private final Provider<CourtRepository> repositoryProvider;

  public GetCourtsUseCase_Factory(Provider<CourtRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetCourtsUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetCourtsUseCase_Factory create(Provider<CourtRepository> repositoryProvider) {
    return new GetCourtsUseCase_Factory(repositoryProvider);
  }

  public static GetCourtsUseCase newInstance(CourtRepository repository) {
    return new GetCourtsUseCase(repository);
  }
}
