package shikiri.board;

import lombok.Builder;
import lombok.experimental.Accessors;

@Builder
@Accessors(fluent = true, chain = true)
public record BoardIn (
    String name,
    String description,
    String userId
) {
    
}
