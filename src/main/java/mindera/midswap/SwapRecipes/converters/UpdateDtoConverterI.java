package mindera.midswap.SwapRecipes.converters;

public interface UpdateDtoConverterI<Entity, UpdateDto> {
    //UpdateDtoConverter apenas para o Vehicle e User, o Rental e a Agency apenas precisam de DtoConverter normal
    UpdateDto entityToUpdateDto(Entity entity);

    Entity updateDtoToEntity(UpdateDto updateDto, Entity entity);
}
