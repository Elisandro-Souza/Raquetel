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
public final class CreateCustomerUseCase_Factory implements Factory<CreateCustomerUseCase> {
  private final Provider<CustomerRepository> repositoryProvider;

  public CreateCustomerUseCase_Factory(Provider<CustomerRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public CreateCustomerUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static CreateCustomerUseCase_Factory create(
      Provider<CustomerRepository> repositoryProvider) {
    return new CreateCustomerUseCase_Factory(repositoryProvider);
  }

  public static CreateCustomerUseCase newInstance(CustomerRepository repository) {
    return new CreateCustomerUseCase(repository);
  }
}
