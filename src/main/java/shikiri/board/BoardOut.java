package shikiri.board;

import lombok.Builder;
import lombok.experimental.Accessors;

@Builder
@Accessors(fluent = true, chain = true)
public record BoardOut (
    String id,
    String name,
    String userId
) {
    
}
