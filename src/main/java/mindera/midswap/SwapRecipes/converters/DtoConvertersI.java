package mindera.midswap.SwapRecipes.converters;

import java.util.List;

public interface DtoConvertersI<Entity, Dto> {

    Dto entityToDto(Entity entity);

    Entity dtoToEntity(Dto dto);

    List<Dto> entityListToDtoList(List<Entity> entityList);
}
