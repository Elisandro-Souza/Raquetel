package com.raquetel.app.domain.usecases.customer;

import com.raquetel.app.domain.repositories.CustomerRepository;
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
public final class GetCustomersUseCase_Factory implements Factory<GetCustomersUseCase> {
  private final Provider<CustomerRepository> repositoryProvider;

  public GetCustomersUseCase_Factory(Provider<CustomerRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetCustomersUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetCustomersUseCase_Factory create(
      Provider<CustomerRepository> repositoryProvider) {
    return new GetCustomersUseCase_Factory(repositoryProvider);
  }

  public static GetCustomersUseCase newInstance(CustomerRepository repository) {
    return new GetCustomersUseCase(repository);
  }
}
