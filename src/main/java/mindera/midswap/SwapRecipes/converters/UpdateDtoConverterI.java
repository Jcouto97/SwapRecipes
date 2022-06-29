package mindera.midswap.SwapRecipes.converters;

public interface UpdateDtoConverterI<Entity, UpdateDto> {
    UpdateDto entityToUpdateDto(Entity entity);
    Entity updateDtoToEntity(UpdateDto updateDto, Entity entity);
}
